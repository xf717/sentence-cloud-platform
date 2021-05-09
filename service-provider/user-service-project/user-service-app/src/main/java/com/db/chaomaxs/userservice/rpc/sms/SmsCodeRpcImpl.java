package com.db.chaomaxs.userservice.rpc.sms;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.userservice.manager.sms.UserSmsCodeManager;
import com.db.chaomaxs.userservice.rpc.sms.dto.UserSendSmsCodeReqDTO;
import com.db.chaomaxs.userservice.rpc.sms.dto.UserVerifySmsCodeReqDTO;
import com.db.chaomaxs.userservice.rpc.sms.facade.SmsCodeRpcFacade;
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
public class SmsCodeRpcImpl implements SmsCodeRpcFacade {

  @Autowired
  private UserSmsCodeManager userSmsCodeManager;

  @Override
  public ObjectRestResponse<Boolean> sendSmsCode(UserSendSmsCodeReqDTO sendSmsCodeDTO) {
    return new ObjectRestResponse<>().data(userSmsCodeManager.sendSmsCode(sendSmsCodeDTO));
  }

  @Override
  public ObjectRestResponse<Boolean> verifySmsCode(UserVerifySmsCodeReqDTO verifySmsCodeDTO) {
    return new ObjectRestResponse<>().data(userSmsCodeManager.verifySmsCode(verifySmsCodeDTO));
  }
}
