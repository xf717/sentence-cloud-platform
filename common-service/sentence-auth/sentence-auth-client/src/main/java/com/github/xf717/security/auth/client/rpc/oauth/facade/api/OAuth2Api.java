package com.github.xf717.security.auth.client.rpc.oauth.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.security.auth.client.rpc.oauth.dto.OAuth2CreateAccessTokenReqDTO;
import com.github.xf717.security.auth.client.rpc.oauth.dto.OAuth2CreateAccessTokenRespDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * OAuth2Api
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/26 9:15
 */
public interface OAuth2Api {

  /**
   * 根据用户信息生成token
   *
   * @param oAuth2CreateAccessTokenReqDTO
   * @return
   */
  @PostMapping(value = "/facade/oauth2/create/accessToken")
  ObjectRestResponse<OAuth2CreateAccessTokenRespDTO> createAccessToken(
      @RequestBody OAuth2CreateAccessTokenReqDTO oAuth2CreateAccessTokenReqDTO);

  /**
   * 刷新token
   *
   * @return
   */
  @GetMapping(value = "/facade/oauth2/refresh/accessToken")
  ObjectRestResponse<String> refreshAccessToken();

  /**
   * 验证token
   *
   * @param token
   * @return
   */
  @GetMapping(value = "/facade/oauth2/check/accessToken")
  ObjectRestResponse<Boolean> checkAccessToken(@RequestParam("token") String token);

  /**
   * 移出token
   *
   * @param token
   * @return
   */
  @DeleteMapping("/facade/oauth2/remove/accessToken")
  BaseResponse removeAccessToken(@RequestParam("token") String token);


}
