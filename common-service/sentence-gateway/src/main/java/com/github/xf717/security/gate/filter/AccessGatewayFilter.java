package com.github.xf717.security.gate.filter;

import com.alibaba.fastjson.JSONObject;
import com.github.xf717.common.framework.constant.RedisKeyConstant;
import com.github.xf717.common.framework.context.BaseContextHandler;
import com.github.xf717.common.framework.exception.auth.UserTokenException;
import com.github.xf717.common.framework.jwt.IJWTInfo;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.auth.TokenForbiddenResponse;
import com.github.xf717.common.framework.util.base.annotation.NotNull;
import com.github.xf717.common.framework.vo.authority.PermissionInfo;
import com.github.xf717.common.framework.vo.log.LogInfo;
import com.github.xf717.security.auth.client.config.UserAuthConfig;
import com.github.xf717.security.auth.client.jwt.UserAuthUtil;
import com.github.xf717.security.gate.config.GateIgnoreConfig;
import com.github.xf717.security.gate.handler.RequestBodyRoutePredicateFactory;
import com.github.xf717.security.gate.service.LogService;
import com.github.xf717.security.gate.utils.DBLog;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author xiaofeng
 * @create 2018/3/12.
 */
@Configuration
@Slf4j
@RefreshScope  // nacos 动态刷新
public class AccessGatewayFilter implements GlobalFilter {

  @Autowired
  private LogService logService;

//  @Value("${gate.ignore.startWith}")
//  private String startWith;

  @Autowired
  private GateIgnoreConfig gateIgnoreConfig;

  private static final String GATE_WAY_PREFIX = "/api";

  @Autowired
  private UserAuthUtil userAuthUtil;

  @Autowired
  private UserAuthConfig userAuthConfig;

  @Autowired
  private WebClient.Builder webClientBuilder;

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Override
  public Mono<Void> filter(ServerWebExchange serverWebExchange,
      GatewayFilterChain gatewayFilterChain) {
    log.info("check token and user permission....");
    LinkedHashSet requiredAttribute = serverWebExchange
        .getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
    ServerHttpRequest request = serverWebExchange.getRequest();
    // 获取当前网关访问的URI
    String requestUri = request.getPath().pathWithinApplication().value();
    log.info("最原始的requestUri===========" + requestUri);
    if (requiredAttribute != null) {
      Iterator<URI> iterator = requiredAttribute.iterator();
      while (iterator.hasNext()) {
        URI next = iterator.next();
        final String path = next.getPath();
        log.info("path===" + path);
        // path===/api/passport/rest/passport/send-sms-code
        if (next.getPath().startsWith(GATE_WAY_PREFIX)) {
          // 只截取api 会出现问题, 截完后 url 是 passport/rest/passport/send-sms-code,
          // 我们要的只是 /rest/passport/send-sms-code ,所以这里就不substring,直接使用requestUri,因为requestUri==/rest/passport/send-sms-code
//          requestUri = next.getPath().substring(GATE_WAY_PREFIX.length());
          log.info("包含api前缀的requestUri==" + requestUri);
        }
      }
    }
    final String method = request.getMethod().toString();
    BaseContextHandler.setToken(null);
    ServerHttpRequest.Builder mutate = request.mutate();
    // 网关不进行拦截的URI配置，常见如验证码、Login接口
    if (isStartWith(requestUri)) {
      ServerHttpRequest build = mutate.build();
      return gatewayFilterChain.filter(serverWebExchange.mutate().request(build).build());
    }
    IJWTInfo user = null;
    try {
      // 判断用户token，获取用户信息
      user = getJWTUser(request, mutate);
    } catch (Exception e) {
      log.error("用户Token过期异常", e);
      return getVoidMono(serverWebExchange,
          new TokenForbiddenResponse("User Token Error or Expired!"), HttpStatus.UNAUTHORIZED);
    }

//    Mono<CheckPermissionInfo> checkPermissionInfoMono = webClientBuilder.build().
//        get().uri("http://ace-admin/api/user/{username}/check_permission?requestMethod=" + method
//        + "&requestUri=" + requestUri, user.getUniqueName())
//        .header(userAuthConfig.getTokenHeader(), BaseContextHandler.getToken()).retrieve()
//        .bodyToMono(CheckPermissionInfo.class);

//    IJWTInfo finalUser = user;
//    return checkPermissionInfoMono.flatMap(checkPermissionInfo -> {
//      // 当前用户具有访问权限
//      if (checkPermissionInfo.getIsAuth()) {
//        if (checkPermissionInfo.getPermissionInfo() != null) {
//          // 若资源存在则请求设置访问日志
//          setCurrentUserInfoAndLog(serverWebExchange, finalUser,
//              checkPermissionInfo.getPermissionInfo());
//        }
//        ServerHttpRequest build = mutate.build();
//        return gatewayFilterChain.filter(serverWebExchange.mutate().request(build).build());
//      } else {
//        // 当前用户不具有访问权限
//        return getVoidMono(serverWebExchange,
//            new TokenForbiddenResponse("Forbidden!Does not has Permission!"), HttpStatus.FORBIDDEN);
//      }
//    });
    // TODO 暂定先不进行判断拦截,后面根据不同端进行验证,或者等量大的时候拆成不同的网关
    ServerHttpRequest build = mutate.build();
    return gatewayFilterChain.filter(serverWebExchange.mutate().request(build).build());
  }

  /**
   * 网关抛异常
   *
   * @param body
   */
  @NotNull
  private Mono<Void> getVoidMono(ServerWebExchange serverWebExchange, BaseResponse body,
      HttpStatus status) {
    serverWebExchange.getResponse().setStatusCode(status);
    byte[] bytes = JSONObject.toJSONString(body).getBytes(StandardCharsets.UTF_8);
    DataBuffer buffer = serverWebExchange.getResponse().bufferFactory().wrap(bytes);
    return serverWebExchange.getResponse().writeWith(Flux.just(buffer));
  }


  private void setCurrentUserInfoAndLog(ServerWebExchange serverWebExchange, IJWTInfo user,
      PermissionInfo pm) {
    String host = serverWebExchange.getRequest().getRemoteAddress().toString();
    LogInfo logInfo = new LogInfo(pm.getMenu(), pm.getName(), pm.getUri(), new Date(), user.getId(),
        user.getName(), host, String.valueOf(
        serverWebExchange.getAttributes().get(RequestBodyRoutePredicateFactory.REQUEST_BODY_ATTR)));
    DBLog.getInstance().setLogService(logService).offerQueue(logInfo);
  }

  /**
   * 返回session中的用户信息
   *
   * @param request
   * @param ctx
   * @return
   */
  private IJWTInfo getJWTUser(ServerHttpRequest request, ServerHttpRequest.Builder ctx)
      throws Exception {
    List<String> strings = request.getHeaders().get(userAuthConfig.getTokenHeader());
    String authToken = null;
    if (strings != null) {
      authToken = strings.get(0);
    }
    if (StringUtils.isBlank(authToken)) {
      strings = request.getQueryParams().get("token");
      if (strings != null) {
        authToken = strings.get(0);
      }
    }
    IJWTInfo infoFromToken = userAuthUtil.getInfoFromToken(authToken);
    String s = stringRedisTemplate.opsForValue()
        .get(RedisKeyConstant.REDIS_KEY_TOKEN + ":" + infoFromToken.getTokenId());
    if (StringUtils.isBlank(s)) {
      throw new UserTokenException("User token expired!");
    }
    ctx.header(userAuthConfig.getTokenHeader(), authToken);
    BaseContextHandler.setToken(authToken);
    return infoFromToken;
  }


  /**
   * URI是否以什么打头
   *
   * @param requestUri
   * @return
   */
  private boolean isStartWith(String requestUri) {
    boolean flag = false;
//    for (String s : startWith.split(",")) {
//      if (requestUri.startsWith(s)) {
//        return true;
//      }
//    }
    System.out.println("ignores==" + gateIgnoreConfig.getIgnores());
    for (String ignore : gateIgnoreConfig.getIgnores()) {
      if (requestUri.startsWith(ignore)) {
        return true;
      }
    }
    return flag;
  }


}
