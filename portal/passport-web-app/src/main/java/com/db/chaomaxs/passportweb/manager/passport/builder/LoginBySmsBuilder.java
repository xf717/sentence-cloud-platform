package com.db.chaomaxs.passportweb.manager.passport.builder;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.passportweb.controller.passport.dto.PassportLoginBySmsReqDTO;
import com.db.chaomaxs.passportweb.manager.passport.handler.AbstractLoginHandler;
import com.db.chaomaxs.passportweb.service.sms.VerifySmsCodeService;
import com.db.chaomaxs.security.auth.client.rpc.oauth.facade.OAuth2RpcFacade;
import com.db.chaomaxs.userservice.enums.UserErrorCodeConstants;
import com.db.chaomaxs.userservice.enums.sms.UserSmsSceneEnum;
import com.db.chaomaxs.userservice.enums.user.UserLoginTypeEnum;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserInfoRpcFacade;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * 短信登录--构建者模式
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/12 15:30
 */
public class LoginBySmsBuilder extends
    AbstractLoginHandler<UserInfoRespDTO, PassportLoginBySmsReqDTO> {

  private UserInfoRpcFacade userInfoRpcFacade;
  private String ip;
  private VerifySmsCodeService verifySmsCodeService;

  public LoginBySmsBuilder(OAuth2RpcFacade oAuth2RpcFacade, StringRedisTemplate stringRedisTemplate,
      PassportLoginBySmsReqDTO loginBySmsReqDTO) {
    super(oAuth2RpcFacade, stringRedisTemplate, loginBySmsReqDTO);
  }

  public LoginBySmsBuilder userInfoRpcFacade(UserInfoRpcFacade userInfoRpcFacade) {
    this.userInfoRpcFacade = userInfoRpcFacade;
    return this;
  }

  public LoginBySmsBuilder ip(String ip) {
    this.ip = ip;
    return this;
  }

  public LoginBySmsBuilder verifySmsCodeService(VerifySmsCodeService verifySmsCodeService) {
    this.verifySmsCodeService = verifySmsCodeService;
    return this;
  }


  @Override
  public UserInfoRespDTO build(PassportLoginBySmsReqDTO passportLoginBySmsReqDTO) {
    // 短信验证
    boolean hasSuccess = verifySmsCodeService
        .verifySmsCode(passportLoginBySmsReqDTO.getMobile(), passportLoginBySmsReqDTO.getCode(), ip,
            UserSmsSceneEnum.LOGIN_BY_SMS);
    if (hasSuccess) {
      UserInfoCreateReqDTO createReqDTO = new UserInfoCreateReqDTO()
          .setMobile(passportLoginBySmsReqDTO.getMobile())
          .setRegisterIp(ip)
          .setUserLoginType(UserLoginTypeEnum.LOGIN_BY_SMS.getValue())
          .setLoginRegisterSource(passportLoginBySmsReqDTO.getLoginRegisterSource());
      ObjectRestResponse<UserInfoRespDTO> objectRestResponse = userInfoRpcFacade
          .createUserIfAbsent(createReqDTO);
      objectRestResponse.checkError();
      return objectRestResponse.getData();
    }
    throw ServiceExceptionUtil.exception(UserErrorCodeConstants.LOGIN_BY_SMS_ERROR.getCode());
  }
}
