package com.db.chaomaxs.passportweb.manager.passport.handler;

import com.alibaba.fastjson.JSON;
import com.db.chaomaxs.common.framework.constant.RedisKeyConstant;
import com.db.chaomaxs.common.framework.exception.auth.UserTokenException;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.util.AddressUtils;
import com.db.chaomaxs.common.framework.util.IpUtils;
import com.db.chaomaxs.common.framework.util.WebUtils;
import com.db.chaomaxs.passportweb.controller.passport.vo.PassportTokenRespVO;
import com.db.chaomaxs.passportweb.manager.passport.bo.OnlineLogBO;
import com.db.chaomaxs.security.auth.client.rpc.oauth.dto.OAuth2CreateAccessTokenReqDTO;
import com.db.chaomaxs.security.auth.client.rpc.oauth.dto.OAuth2CreateAccessTokenRespDTO;
import com.db.chaomaxs.security.auth.client.rpc.oauth.facade.OAuth2RpcFacade;
import eu.bitwalker.useragentutils.UserAgent;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;

/**
 * 登录生成token 模板方法-模板模式
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/12 11:38
 */
public abstract class AbstractLoginHandler<T extends Serializable, E> {

  private final OAuth2RpcFacade oAuth2RpcFacade;
  private final StringRedisTemplate stringRedisTemplate;
  private final E e;

  protected AbstractLoginHandler(
      OAuth2RpcFacade oAuth2RpcFacade, StringRedisTemplate stringRedisTemplate, E e) {
    this.oAuth2RpcFacade = oAuth2RpcFacade;
    this.stringRedisTemplate = stringRedisTemplate;
    this.e = e;
  }

  /**
   * 登录模板
   *
   * @param username
   * @param userId
   * @param name
   * @return
   */
  private OAuth2CreateAccessTokenRespDTO createAccessToken(String username, String userId,
      String name) {
    // 没有业务处理，就没有返回值了
    if (StringUtils.isNotEmpty(userId)) {
      OAuth2CreateAccessTokenReqDTO createAccessToken = new OAuth2CreateAccessTokenReqDTO()
          .setUsername(username)
          .setUserId(userId)
          .setName(name);

      ObjectRestResponse<OAuth2CreateAccessTokenRespDTO> objectRestResponse = oAuth2RpcFacade
          .createAccessToken(createAccessToken);
      objectRestResponse.checkError();
      return objectRestResponse.getData();
    }
    throw new UserTokenException("创建accessToken 失败");
  }

  /**
   * 登录
   *
   * @param username
   * @param userId
   * @param name
   * @return
   */
  public PassportTokenRespVO login(String username, String userId, String name) {
    OAuth2CreateAccessTokenRespDTO createAccessTokenResp = this
        .createAccessToken(username, userId, name);
    if (createAccessTokenResp != null) {
      this.writeOnlineLog(createAccessTokenResp);
    }
    return new PassportTokenRespVO().setAccessToken(createAccessTokenResp.getToken());
  }

  /**
   * 创建用户返回的用户信息
   *
   * @param e 参数信息
   * @return
   */
  public abstract T build(E e);

  @Async
  public void writeOnlineLog(OAuth2CreateAccessTokenRespDTO createAccessTokenResp) {
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
    onlineLog.setTokenId(createAccessTokenResp.getTokenId());
    onlineLog.setLoginTime(System.currentTimeMillis());
    onlineLog.setUserId(createAccessTokenResp.getUserId());
    onlineLog.setUserName(createAccessTokenResp.getName());
    onlineLog.setLoginLocation(address);
    onlineLog.setOs(os);
    stringRedisTemplate.opsForValue()
        .set(RedisKeyConstant.REDIS_KEY_TOKEN + ":" + createAccessTokenResp.getTokenId(),
            JSON.toJSONString(onlineLog, false), 259200, TimeUnit.SECONDS);
    stringRedisTemplate.opsForZSet()
        .add((RedisKeyConstant.REDIS_KEY_TOKEN), createAccessTokenResp.getTokenId(), 0);
  }


}
