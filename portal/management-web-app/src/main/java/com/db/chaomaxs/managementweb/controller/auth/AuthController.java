package com.db.chaomaxs.managementweb.controller.auth;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.managementweb.controller.auth.dto.JwtAuthenticationRequest;
import com.db.chaomaxs.managementweb.manager.auth.AuthManager;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jwt")
@Slf4j
public class AuthController {

  @Autowired
  protected HttpServletRequest request;

  @Autowired
  private AuthManager authManager;

  @RequestMapping(value = "token", method = RequestMethod.POST)
  public ObjectRestResponse<String> createAuthenticationToken(
      @RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {
    log.info(authenticationRequest.getUsername() + " require logging...");
    Map<String, String> result = authManager.login(authenticationRequest);
    return new ObjectRestResponse<>().data(result);
  }

  @GetMapping("/refresh")
  @ApiOperation(value = "刷新token", nickname = "refreshToken")
  public ObjectRestResponse<String> refreshToken() throws Exception {
    String refreshedToken = authManager.refresh();
    return new ObjectRestResponse<>().data(refreshedToken);
  }

  @GetMapping("/verify")
  @ApiOperation(value = "验证token", nickname = "verify")
  @ApiImplicitParam(name = "token", dataType = "String", paramType = "query", required = true)
  public ObjectRestResponse<?> verify(String token) throws Exception {
    return ObjectRestResponse.success(authManager.validate(token));
  }

  /**
   * 退出
   *
   * @param token
   * @return
   * @throws Exception
   */
  @DeleteMapping("/logout")
  @ApiOperation(value = "退出", nickname = "logout")
  @ApiImplicitParam(name = "token", dataType = "String", paramType = "query", required = true)
  public ObjectRestResponse<?> logout(String token) throws Exception {
    authManager.logout(token);
    return new ObjectRestResponse<>();
  }

}
