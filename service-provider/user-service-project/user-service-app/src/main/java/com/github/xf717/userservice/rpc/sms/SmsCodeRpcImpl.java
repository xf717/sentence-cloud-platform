package com.github.xf717.userservice.rpc.sms;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userservice.manager.sms.UserSmsCodeManager;
import com.github.xf717.userservice.rpc.sms.dto.UserSendSmsCodeReqDTO;
import com.github.xf717.userservice.rpc.sms.dto.UserVerifySmsCodeReqDTO;
import com.github.xf717.userservice.rpc.sms.facade.SmsCodeRpcFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserSmsCodeRpcImpl
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/07 21:12
 */
@Slf4j
@Service
public class SmsCodeRpcImpl {

  @Autowired
  private UserSmsCodeManager userSmsCodeManager;

  public ObjectRestResponse<Boolean> sendSmsCode(UserSendSmsCodeReqDTO sendSmsCodeDTO) {
    return new ObjectRestResponse<>().data(userSmsCodeManager.sendSmsCode(sendSmsCodeDTO));
  }
  
  public ObjectRestResponse<Boolean> verifySmsCode(UserVerifySmsCodeReqDTO verifySmsCodeDTO) {
    return new ObjectRestResponse<>().data(userSmsCodeManager.verifySmsCode(verifySmsCodeDTO));
  }
}
