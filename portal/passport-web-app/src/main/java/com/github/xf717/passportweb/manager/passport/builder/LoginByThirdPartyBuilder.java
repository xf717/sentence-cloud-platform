package com.github.xf717.passportweb.manager.passport.builder;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.passportweb.controller.passport.dto.PassportLoginByThirdPartyReqDTO;
import com.github.xf717.passportweb.convert.passport.PassportConvert;
import com.github.xf717.passportweb.manager.passport.handler.AbstractLoginHandler;
import com.github.xf717.security.auth.client.rpc.oauth.facade.OAuth2RpcFacade;
import com.github.xf717.userservice.enums.user.GenderEnum;
import com.github.xf717.userservice.rpc.user.dto.UserInfoCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoRespDTO;
import com.github.xf717.userservice.rpc.user.facade.UserInfoRpcFacade;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * 第三方登录业务处理
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/12 15:36
 */
public class LoginByThirdPartyBuilder extends
    AbstractLoginHandler<UserInfoRespDTO, PassportLoginByThirdPartyReqDTO> {

  private UserInfoRpcFacade userInfoRpcFacade;
  private String ip;

  public LoginByThirdPartyBuilder userInfoRpcFacade(UserInfoRpcFacade userInfoRpcFacade) {
    this.userInfoRpcFacade = userInfoRpcFacade;
    return this;
  }

  public LoginByThirdPartyBuilder ip(String ip) {
    this.ip = ip;
    return this;
  }

  public LoginByThirdPartyBuilder(OAuth2RpcFacade oAuth2RpcFacade,
      StringRedisTemplate stringRedisTemplate,
      PassportLoginByThirdPartyReqDTO loginByThirdPartyReqDTO) {
    super(oAuth2RpcFacade, stringRedisTemplate, loginByThirdPartyReqDTO);
  }


  @Override
  public UserInfoRespDTO build(PassportLoginByThirdPartyReqDTO thirdPartyReqDTO) {
    UserInfoCreateReqDTO userInfoCreateReq = PassportConvert.INSTANCE.convert(thirdPartyReqDTO);
    if (thirdPartyReqDTO.getSex() == null) {
      // 没有性别，就设置未知的值
      userInfoCreateReq.setGender(GenderEnum.UNKNOWN.getValue());
    }
    userInfoCreateReq.setRegisterIp(ip);
    // 第三方用户如果不存在则进行创建
    ObjectRestResponse<UserInfoRespDTO> objectRestResponse = userInfoRpcFacade
        .createUserIfAbsent(userInfoCreateReq);
    objectRestResponse.checkError();
    return objectRestResponse.getData();
  }

}
