package com.db.chaomaxs.security.auth.service.impl;

import com.db.chaomaxs.common.framework.constant.RedisKeyConstant;
import com.db.chaomaxs.common.framework.exception.auth.UserInvalidException;
import com.db.chaomaxs.common.framework.exception.auth.UserTokenException;
import com.db.chaomaxs.common.framework.jwt.IJWTInfo;
import com.db.chaomaxs.common.framework.jwt.JWTInfo;
import com.db.chaomaxs.security.auth.client.rpc.oauth.dto.OAuth2CreateAccessTokenReqDTO;
import com.db.chaomaxs.security.auth.client.rpc.oauth.dto.OAuth2CreateAccessTokenRespDTO;
import com.db.chaomaxs.security.auth.service.OAuth2Service;
import com.db.chaomaxs.security.auth.util.user.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 权限相关实现类
 *
 * @author xiaofeng
 */
@Service
public class AuthServiceImpl implements OAuth2Service {

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Override
  public OAuth2CreateAccessTokenRespDTO createAccessToken(
      OAuth2CreateAccessTokenReqDTO createAccessTokenReq) {
    if (StringUtils.isNotEmpty(createAccessTokenReq.getUserId())) {
      JWTInfo jwtInfo = new JWTInfo(createAccessTokenReq.getUsername(),
          createAccessTokenReq.getUserId(), createAccessTokenReq.getName());
      String token = null;
      try {
        token = jwtTokenUtil.generateToken(jwtInfo);
      } catch (Exception e) {
        e.printStackTrace();
        throw new UserTokenException("创建token失败");
      }
      // 返回数据，以供其它业务调用
      OAuth2CreateAccessTokenRespDTO createAccessTokenResp = new OAuth2CreateAccessTokenRespDTO()
          .setToken(token)
          .setTokenId(jwtInfo.getTokenId())
          .setName(jwtInfo.getName())
          .setUserId(jwtInfo.getId());
      return createAccessTokenResp;
    }
    throw new UserInvalidException("用户不存在或账户密码错误!");
  }


  @Override
  public String refreshAccessToken(String oldToken) {
    try {
      return jwtTokenUtil.generateToken(jwtTokenUtil.getInfoFromToken(oldToken));
    } catch (Exception e) {
      e.printStackTrace();
      throw new UserTokenException("刷新token异常");
    }
  }

  @Override
  public boolean checkAccessToken(String token) {
    try {
      IJWTInfo ijwtInfo = jwtTokenUtil.getInfoFromToken(token);
      return ijwtInfo != null ? true : false;
    } catch (Exception e) {
      e.printStackTrace();
      throw new UserTokenException("验证token信息异常!");
    }
  }

  @Override
  public void removeAccessToken(String token) {
    IJWTInfo infoFromToken = null;
    try {
      infoFromToken = jwtTokenUtil.getInfoFromToken(token);
    } catch (Exception e) {
      e.printStackTrace();
      throw new UserTokenException("获取token信息异常");
    }
    String tokenId = infoFromToken.getTokenId();
    stringRedisTemplate.delete(RedisKeyConstant.REDIS_KEY_TOKEN + ":" + tokenId);
    stringRedisTemplate.opsForZSet().remove(RedisKeyConstant.REDIS_KEY_TOKEN, tokenId);
  }


}
