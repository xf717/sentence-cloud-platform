package com.db.chaomaxs.passportweb.manager.passport.builder;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.passportweb.controller.passport.dto.PassportLoginByThirdPartyReqDTO;
import com.db.chaomaxs.passportweb.convert.passport.PassportConvert;
import com.db.chaomaxs.passportweb.manager.passport.handler.AbstractLoginHandler;
import com.db.chaomaxs.security.auth.client.rpc.oauth.facade.OAuth2RpcFacade;
import com.db.chaomaxs.userservice.enums.user.GenderEnum;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoRespDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserInfoRpcFacade;
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
