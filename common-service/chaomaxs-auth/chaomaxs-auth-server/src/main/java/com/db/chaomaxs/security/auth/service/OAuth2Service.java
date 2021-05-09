package com.db.chaomaxs.security.auth.service;


import com.db.chaomaxs.security.auth.client.rpc.oauth.dto.OAuth2CreateAccessTokenReqDTO;
import com.db.chaomaxs.security.auth.client.rpc.oauth.dto.OAuth2CreateAccessTokenRespDTO;

/**
 * OAuth2 业务
 *
 * @author xiaofeng
 */
public interface OAuth2Service {

  /**
   * 生成token
   *
   * @param oAuth2CreateAccessTokenReq
   * @return
   */
  OAuth2CreateAccessTokenRespDTO createAccessToken(
      OAuth2CreateAccessTokenReqDTO oAuth2CreateAccessTokenReq);

  /**
   * 刷新token
   *
   * @param oldToken
   * @return
   * @throws Exception
   */
  String refreshAccessToken(String oldToken);

  /**
   * 验证token
   *
   * @param token
   * @return
   */
  boolean checkAccessToken(String token);

  /**
   * 移出token
   *
   * @param token
   * @return
   * @throws Exception
   */
  void removeAccessToken(String token);
}
