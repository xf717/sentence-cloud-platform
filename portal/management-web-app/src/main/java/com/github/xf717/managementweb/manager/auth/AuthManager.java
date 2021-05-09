package com.github.xf717.managementweb.manager.auth;

import static com.github.xf717.common.framework.constant.RedisKeyConstant.REDIS_KEY_CAPTCHA;

import com.alibaba.fastjson.JSON;
import com.github.xf717.common.framework.constant.RedisKeyConstant;
import com.github.xf717.common.framework.exception.auth.UserInvalidException;
import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.util.AddressUtils;
import com.github.xf717.common.framework.util.IpUtils;
import com.github.xf717.common.framework.util.WebUtils;
import com.github.xf717.common.framework.vo.user.UserInfo;
import com.github.xf717.managementweb.controller.auth.dto.JwtAuthenticationRequest;
import com.github.xf717.managementweb.manager.bo.OnlineLogBO;
import com.github.xf717.security.auth.client.rpc.oauth.dto.OAuth2CreateAccessTokenReqDTO;
import com.github.xf717.security.auth.client.rpc.oauth.dto.OAuth2CreateAccessTokenRespDTO;
import com.github.xf717.security.auth.client.rpc.oauth.facade.OAuth2RpcFacade;
import com.github.xf717.systemservice.rpc.auth.facade.PermissionRpcFacade;
import eu.bitwalker.useragentutils.UserAgent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * AuthManager
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/30 16:15
 */
@Service
@Validated
public class AuthManager {

  @Autowired
  private PermissionRpcFacade permissionRpcFacade;

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Autowired
  private OAuth2RpcFacade oAuth2RpcFacade;


  /**
   * 验证SESSION CODE 是否正确
   *
   * @param authenticationRequest
   */
  private void validateSessionCode(JwtAuthenticationRequest authenticationRequest) {
    // 获取session中的验证码
    final String sessionCode = stringRedisTemplate.opsForValue()
        .get(String.format(REDIS_KEY_CAPTCHA, authenticationRequest.getUuid()));
    if (sessionCode == null) {
      throw new UserInvalidException("验证码已过期");
    }
    // 判断验证码
    if (authenticationRequest.getVerCode() == null || !sessionCode
        .equals(authenticationRequest.getVerCode().trim().toLowerCase())) {
      throw new UserInvalidException("验证码不正确");
    }
  }


  /**
   * 用户登录
   *
   * @param authenticationRequest
   * @return
   * @throws Exception
   */
  public Map<String, String> login(JwtAuthenticationRequest authenticationRequest)
      throws Exception {
    this.validateSessionCode(authenticationRequest);
    ObjectRestResponse<UserInfo> objectRestResponse = permissionRpcFacade
        .validate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    objectRestResponse.checkError();
    UserInfo userInfo = objectRestResponse.getData();
    if (StringUtils.isNotEmpty(userInfo.getId())) {
      OAuth2CreateAccessTokenReqDTO oAuth2CreateAccessTokenReq = new OAuth2CreateAccessTokenReqDTO()
          .setUsername(userInfo.getUsername())
          .setUserId(userInfo.getId())
          .setName(userInfo.getName());
      ObjectRestResponse<OAuth2CreateAccessTokenRespDTO> accessTokenObjectRestResponse = oAuth2RpcFacade
          .createAccessToken(oAuth2CreateAccessTokenReq);
      accessTokenObjectRestResponse.checkError();
      OAuth2CreateAccessTokenRespDTO oAuth2CreateAccessTokenResp = accessTokenObjectRestResponse
          .getData();
      Map<String, String> result = new HashMap<>(2);
      result.put("accessToken", accessTokenObjectRestResponse.getData().getToken());
      result.put("id", userInfo.id);
      WebUtils.getRequest();
      writeOnlineLog(oAuth2CreateAccessTokenResp);
      return result;
    }
    throw new UserInvalidException("用户不存在或账户密码错误!");
  }

  /**
   * 验证
   *
   * @param token
   * @throws Exception
   */
  public boolean validate(String token) {
    ObjectRestResponse<Boolean> objectRestResponse = oAuth2RpcFacade.checkAccessToken(token);
    objectRestResponse.checkError();
    return objectRestResponse.getData();
  }

  /**
   * 刷新token
   *
   * @return
   * @throws Exception
   */
  public String refresh() {
    ObjectRestResponse<String> objectRestResponse = oAuth2RpcFacade.refreshAccessToken();
    objectRestResponse.checkError();
    return objectRestResponse.getData();
  }

  /**
   * 退出
   *
   * @param token
   * @throws Exception
   */
  public void logout(String token) throws Exception {
    BaseResponse baseResponse = oAuth2RpcFacade.removeAccessToken(token);
    baseResponse.checkError();
  }

  @Async
  public void writeOnlineLog(OAuth2CreateAccessTokenRespDTO oAuth2CreateAccessTokenResp) {
    final UserAgent userAgent = UserAgent
        .parseUserAgentString(WebUtils.getRequest().getHeader("User-Agent"));
    final String ip = IpUtils.getRemoteIP(WebUtils.getRequest());
    String address = AddressUtils.getRealAddressByIP(ip);

    OnlineLogBO onlineLog = new OnlineLogBO();
    // 获取客户端操作系统
    String os = userAgent.getOperatingSystem().getName();
    // 获取客户端浏览器
    String browser = userAgent.getBrowser().getName();
    onlineLog.setBrowser(browser);
    onlineLog.setIpaddr(ip);
    onlineLog.setTokenId(oAuth2CreateAccessTokenResp.getTokenId());
    onlineLog.setLoginTime(System.currentTimeMillis());
    onlineLog.setUserId(oAuth2CreateAccessTokenResp.getUserId());
    onlineLog.setUserName(oAuth2CreateAccessTokenResp.getName());
    onlineLog.setLoginLocation(address);
    onlineLog.setOs(os);
    stringRedisTemplate.opsForValue()
        .set(RedisKeyConstant.REDIS_KEY_TOKEN + ":" + oAuth2CreateAccessTokenResp.getTokenId(), JSON
            .toJSONString(onlineLog, false), 259200, TimeUnit.SECONDS);
    stringRedisTemplate.opsForZSet()
        .add(RedisKeyConstant.REDIS_KEY_TOKEN, oAuth2CreateAccessTokenResp.getTokenId(), 0);
  }

}
