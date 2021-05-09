package com.db.chaomaxs.passportweb.manager.passport;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeRespDTO;
import com.db.chaomaxs.logservice.rpc.sms.facade.UserSmsCodeRpcFacade;
import com.db.chaomaxs.passportweb.controller.passport.dto.PassportLoginByAccountPasswordReqDTO;
import com.db.chaomaxs.passportweb.controller.passport.dto.PassportLoginBySmsReqDTO;
import com.db.chaomaxs.passportweb.controller.passport.dto.PassportLoginByThirdPartyReqDTO;
import com.db.chaomaxs.passportweb.controller.passport.dto.PassportSendSmsReqDTO;
import com.db.chaomaxs.passportweb.controller.passport.vo.PassportTokenRespVO;
import com.db.chaomaxs.passportweb.manager.passport.builder.LoginByAccountPasswordBuilder;
import com.db.chaomaxs.passportweb.manager.passport.builder.LoginBySmsBuilder;
import com.db.chaomaxs.passportweb.manager.passport.builder.LoginByThirdPartyBuilder;
import com.db.chaomaxs.passportweb.service.sms.VerifySmsCodeService;
import com.db.chaomaxs.security.auth.client.rpc.oauth.facade.OAuth2RpcFacade;
import com.db.chaomaxs.userservice.enums.sms.UserSmsSceneEnum;
import com.db.chaomaxs.userservice.rpc.sms.dto.UserSendSmsCodeReqDTO;
import com.db.chaomaxs.userservice.rpc.sms.facade.SmsCodeRpcFacade;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserInfoRpcFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * PassportManager
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/06 21:23
 */
@Service
@Validated
public class PassportManager {

  @Autowired
  private UserSmsCodeRpcFacade userSmsCodeRpcFacade;

  @Autowired
  private UserInfoRpcFacade userInfoRpcFacade;

  @Autowired
  private SmsCodeRpcFacade smsCodeRpcFacade;

  @Autowired
  private OAuth2RpcFacade oAuth2RpcFacade;

  @Autowired
  private VerifySmsCodeService verifySmsCodeService;

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  /**
   * 手机验证码登录
   *
   * @param passportLoginBySmsReqDTO
   * @param ip
   * @return
   */
  public PassportTokenRespVO loginBySms(PassportLoginBySmsReqDTO passportLoginBySmsReqDTO,
      String ip) {
    LoginBySmsBuilder loginBySmsBuilder = new LoginBySmsBuilder(oAuth2RpcFacade,
        stringRedisTemplate,
        passportLoginBySmsReqDTO)
        .userInfoRpcFacade(userInfoRpcFacade)
        .ip(ip)
        .verifySmsCodeService(verifySmsCodeService);
    UserInfoRespDTO userInfo = loginBySmsBuilder.build(passportLoginBySmsReqDTO);
    return loginBySmsBuilder.login(userInfo.getMobile(),
        userInfo.getId().toString(), userInfo.getNickname());
  }

  /**
   * 构建名称
   *
   * @param mobile
   * @param id
   * @return
   */
  private String buildName(String mobile, Long id) {
    return mobile + ":" + id;
  }

  /**
   * 第三方登录
   *
   * @param thirdPartyReqDTO
   * @return
   */
  public PassportTokenRespVO loginByThirdParty(PassportLoginByThirdPartyReqDTO thirdPartyReqDTO,
      String ip) {
    LoginByThirdPartyBuilder builder = new LoginByThirdPartyBuilder(oAuth2RpcFacade,
        stringRedisTemplate,
        thirdPartyReqDTO)
        .userInfoRpcFacade(userInfoRpcFacade)
        .ip(ip);
    // 构建登录业务
    UserInfoRespDTO userInfoResp = builder.build(thirdPartyReqDTO);

    return builder.login(userInfoResp.getMobile(),
        userInfoResp.getId().toString(), userInfoResp.getNickname());
  }

  /**
   * 微信扫码第三方登录
   *
   * @param code
   * @param ip
   * @return
   */
//  public PassportTokenRespVO loginByThirdPartyWxQrConnect(String code, String ip) {
//    WxMpUser wxMpUser = this.wxService.getUserInfo(code);
//    if (wxMpUser == null) {
//      throw new UserInvalidException("获取微信用户信息失败");
//    }
//
//    LoginByThirdPartyWxQrConnectBuilder builder = new LoginByThirdPartyWxQrConnectBuilder(
//        jwtTokenUtil, wxMpUser).userThirdRpcFacade(userThirdRpcFacade).ip(ip);
//    // 构建登录业务
//    UserThirdRespDTO userThirdResp = builder.build(wxMpUser);
//
//    return builder.createAccessToken(userThirdResp.getThirdIden(),
//        userThirdResp.getUserId().toString(), userThirdResp.getNickname());
//  }

  /**
   * 帐号密码登录
   *
   * @param loginByAccountPasswordReqDTO
   * @param ip
   * @return
   */
  public PassportTokenRespVO loginByAccountPassword(
      PassportLoginByAccountPasswordReqDTO loginByAccountPasswordReqDTO, String ip) {
    LoginByAccountPasswordBuilder builder = new LoginByAccountPasswordBuilder(oAuth2RpcFacade,
        stringRedisTemplate,
        loginByAccountPasswordReqDTO).userInfoRpcFacade(userInfoRpcFacade);
    UserInfoRespDTO userInfo = builder.build(loginByAccountPasswordReqDTO);
    return builder
        .login(userInfo.getMobile(), userInfo.getId().toString(),
            userInfo.getNickname());
  }

  /**
   * 发送短信验证码
   *
   * @param sendSmsCodeDTO
   * @param ip
   * @return
   */
  public boolean sendSmsCode(PassportSendSmsReqDTO sendSmsCodeDTO, String ip) {
    // 校验是否可以发送验证码，不用筛选场景,所以默认为UserSmsSceneEnum.UNKNOWN
    ObjectRestResponse<UserSmsCodeRespDTO> objectRestResponse = userSmsCodeRpcFacade
        .getLastCodeByMobile(sendSmsCodeDTO.getMobile(), UserSmsSceneEnum.UNKNOWN.getValue());
    objectRestResponse.checkError();

    UserSendSmsCodeReqDTO userSendSmsCodeReqDTO = new UserSendSmsCodeReqDTO()
        .setMobile(sendSmsCodeDTO.getMobile())
        .setScene(sendSmsCodeDTO.getScene())
        .setIp(ip);
    final UserSmsCodeRespDTO lastUserSmsCode = objectRestResponse.getData();
    if (lastUserSmsCode != null) {
      userSendSmsCodeReqDTO.setTodayIndex(lastUserSmsCode.getTodayIndex());
      userSendSmsCodeReqDTO.setLastUserSmsCodeTime(lastUserSmsCode.getCreateTime());
    }
    ObjectRestResponse<Boolean> sendSmsResponse = smsCodeRpcFacade
        .sendSmsCode(userSendSmsCodeReqDTO);
    sendSmsResponse.checkError();
    return sendSmsResponse.getData();
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
  public void logout(String token) {
    BaseResponse baseResponse = oAuth2RpcFacade.removeAccessToken(token);
    baseResponse.checkError();
  }

}
