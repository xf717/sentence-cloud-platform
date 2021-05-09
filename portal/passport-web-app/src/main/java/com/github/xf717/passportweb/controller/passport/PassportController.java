package com.github.xf717.passportweb.controller.passport;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.util.WebUtils;
import com.github.xf717.common.framework.util.http.HttpUtil;
import com.github.xf717.passportweb.controller.passport.dto.PassportLoginByAccountPasswordReqDTO;
import com.github.xf717.passportweb.controller.passport.dto.PassportLoginBySmsReqDTO;
import com.github.xf717.passportweb.controller.passport.dto.PassportLoginByThirdPartyReqDTO;
import com.github.xf717.passportweb.controller.passport.dto.PassportSendSmsReqDTO;
import com.github.xf717.passportweb.controller.passport.vo.PassportTokenRespVO;
import com.github.xf717.passportweb.manager.passport.PassportManager;
import com.github.xf717.security.auth.client.annotation.IgnoreUserToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 求职_登录
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Api(value = "登录", description = "登录", tags = "passport")
@RestController
@RequestMapping("/rest/passport")
public class PassportController {

  @Autowired
  private PassportManager passportManager;

  /**
   * 短信登录
   *
   * @param passportLoginBySmsReqDTO
   * @return
   */
  @PostMapping("/login-by-sms")
  @ApiOperation(value = "手机验证码登陆", produces = "application/json", nickname = "loginBySms")
  @IgnoreUserToken
  public ObjectRestResponse<PassportTokenRespVO> loginBySms(
      @Valid @RequestBody PassportLoginBySmsReqDTO passportLoginBySmsReqDTO) {
    final String ip = HttpUtil.getIp(WebUtils.getRequest());
    PassportTokenRespVO passportToken = passportManager.loginBySms(passportLoginBySmsReqDTO, ip);
    return ObjectRestResponse.success(passportToken);
  }

  /**
   * 第三登录-小程序
   *
   * @param thirdPartyReqDTO
   * @return
   */
  @PostMapping("/login-by-third-party")
  @ApiOperation(value = "第三方登录", produces = "application/json", nickname = "loginByThirdParty")
  @IgnoreUserToken
  public ObjectRestResponse<PassportTokenRespVO> loginByThirdParty(
      @Valid @RequestBody PassportLoginByThirdPartyReqDTO thirdPartyReqDTO) {
    final String ip = HttpUtil.getIp(WebUtils.getRequest());
    PassportTokenRespVO passportToken = passportManager.loginByThirdParty(thirdPartyReqDTO, ip);
    return ObjectRestResponse.success(passportToken);
  }

  /**
   * 微信扫码登录
   *
   * @param code
   * @return
   */
//  @PostMapping("/login-by-third-party-wxqrconnect")
//  @ApiOperation(value = "微信扫码登录", produces = "application/json", nickname = "loginByThirdPartyWxQrConnect")
//  @ApiImplicitParam(name = "code", dataType = "String", paramType = "query", required = true)
//  @IgnoreUserToken
//  public ObjectRestResponse<PassportTokenRespVO> loginByThirdPartyWxQrConnect(String code) {
//    final String ip = HttpUtil.getIp(WebUtils.getRequest());
//    PassportTokenRespVO passportToken = passportManager.loginByThirdPartyWxQrConnect(code, ip);
//    return ObjectRestResponse.success(passportToken);
//  }

  /**
   * 帐号密码登录
   *
   * @param loginByAccountPasswordReqDTO
   * @return
   */
  @PostMapping("/login-by-account-password")
  @ApiOperation(value = "帐号密码登录", produces = "application/json", nickname = "loginByAccountPassword")
  @IgnoreUserToken
  public ObjectRestResponse<PassportTokenRespVO> loginByAccountPassword(
      @Valid @RequestBody PassportLoginByAccountPasswordReqDTO loginByAccountPasswordReqDTO) {
    final String ip = HttpUtil.getIp(WebUtils.getRequest());
    PassportTokenRespVO passportToken = passportManager
        .loginByAccountPassword(loginByAccountPasswordReqDTO, ip);
    return ObjectRestResponse.success(passportToken);
  }


  /**
   * 发送短信
   *
   * @param sendSmsCodeDTO
   * @return
   */
  @PostMapping("/send-sms-code")
  @ApiOperation(value = "发送手机验证码", produces = "application/json", nickname = "sendSmsCode")
  @IgnoreUserToken
  public ObjectRestResponse<Boolean> sendSmsCode(
      @Valid @RequestBody PassportSendSmsReqDTO sendSmsCodeDTO) {
    final String ip = HttpUtil.getIp(WebUtils.getRequest());
    boolean hasSuccess = passportManager.sendSmsCode(sendSmsCodeDTO, ip);
    return ObjectRestResponse.success(hasSuccess);
  }

  /**
   * 刷新token
   *
   * @param request
   * @return
   * @throws Exception
   */
  @GetMapping("/refresh-token")
  @ApiOperation(value = "刷新token", nickname = "refreshToken")
  public ObjectRestResponse<String> refreshToken() {
    String refreshedToken = passportManager.refresh();
    return new ObjectRestResponse<>().data(refreshedToken);
  }

  /**
   * 验证token是否正常
   *
   * @param token
   * @return
   */
  @GetMapping("/verify-token")
  @ApiOperation(value = "验证token", nickname = "verifyToken")
  @ApiImplicitParam(name = "token", dataType = "String", paramType = "query", required = true)
  public ObjectRestResponse<Boolean> verifyToken(String token) {
    return ObjectRestResponse.success(passportManager.validate(token));
  }

  /**
   * 退出登录
   *
   * @param token
   * @return
   */
  @DeleteMapping("/logout")
  @ApiOperation(value = "退出", nickname = "logout")
  @ApiImplicitParam(name = "token", dataType = "String", paramType = "query", required = true)
  public BaseResponse logout(String token) {
    passportManager.logout(token);
    return BaseResponse.success("退出成功");
  }


}
