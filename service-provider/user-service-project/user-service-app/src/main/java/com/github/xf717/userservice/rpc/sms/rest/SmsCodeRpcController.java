package com.github.xf717.userservice.rpc.sms.rest;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.userservice.rpc.sms.SmsCodeRpcImpl;
import com.github.xf717.userservice.rpc.sms.dto.UserSendSmsCodeReqDTO;
import com.github.xf717.userservice.rpc.sms.dto.UserVerifySmsCodeReqDTO;
import com.github.xf717.userservice.rpc.sms.facade.api.SmsCodeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserSmsCodeRpcController
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/07 21:10
 */
@RestController
public class SmsCodeRpcController implements SmsCodeApi {

  @Autowired
  private SmsCodeRpcImpl userSmsCodeRpc;

  @Override
  public ObjectRestResponse<Boolean> sendSmsCode(UserSendSmsCodeReqDTO sendSmsCodeDTO) {
    return userSmsCodeRpc.sendSmsCode(sendSmsCodeDTO);
  }

  @Override
  public ObjectRestResponse<Boolean> verifySmsCode(UserVerifySmsCodeReqDTO verifySmsCodeDTO) {
    return userSmsCodeRpc.verifySmsCode(verifySmsCodeDTO);
  }
}
