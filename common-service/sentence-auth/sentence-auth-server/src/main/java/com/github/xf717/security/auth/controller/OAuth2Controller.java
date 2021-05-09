package com.github.xf717.security.auth.controller;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.util.WebUtils;
import com.github.xf717.security.auth.client.rpc.oauth.dto.OAuth2CreateAccessTokenReqDTO;
import com.github.xf717.security.auth.client.rpc.oauth.dto.OAuth2CreateAccessTokenRespDTO;
import com.github.xf717.security.auth.client.rpc.oauth.facade.api.OAuth2Api;
import com.github.xf717.security.auth.service.OAuth2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * 权限token
 *
 * @author xiaofeng
 */
@RestController
public class OAuth2Controller implements OAuth2Api {

  @Autowired
  private OAuth2Service authService;

  @Value("${jwt.token-header}")
  private String tokenHeader;

  @Override
  public ObjectRestResponse<OAuth2CreateAccessTokenRespDTO> createAccessToken(
      OAuth2CreateAccessTokenReqDTO oAuth2CreateAccessTokenReqDTO) {
    OAuth2CreateAccessTokenRespDTO token = authService
        .createAccessToken(oAuth2CreateAccessTokenReqDTO);
    return new ObjectRestResponse<>().data(token);
  }

  @Override
  public ObjectRestResponse<String> refreshAccessToken() {
    String token = WebUtils.getRequest().getHeader(tokenHeader);
    String refreshedToken = authService.refreshAccessToken(token);
    return new ObjectRestResponse<>().data(refreshedToken);
  }

  @Override
  public ObjectRestResponse<Boolean> checkAccessToken(String token) {
    return ObjectRestResponse.success(authService.checkAccessToken(token));
  }

  @Override
  public BaseResponse removeAccessToken(String token) {
    authService.removeAccessToken(token);
    return BaseResponse.success("移除TOKEN成功");
  }


}
