package com.db.chaomaxs.userservice.manager.sms;

import com.db.chaomaxs.sms.core.handler.SmsSendHandler;
import com.db.chaomaxs.userservice.rpc.sms.dto.UserSendSmsCodeReqDTO;
import com.db.chaomaxs.userservice.rpc.sms.dto.UserVerifySmsCodeReqDTO;
import com.db.chaomaxs.userservice.service.sms.UserSmsCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 短信验证码业务
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Service
@Validated
public class UserSmsCodeManager {

  @Autowired
  private UserSmsCodeService userSmsCodeService;

  @Autowired
  private SmsSendHandler handler;

  /**
   * 发送短信
   *
   * @param sendSmsCodeDTO
   * @return
   */
  public boolean sendSmsCode(UserSendSmsCodeReqDTO sendSmsCodeDTO) {
    final String code = userSmsCodeService
        .createSmsCode(sendSmsCodeDTO.getMobile(), sendSmsCodeDTO.getScene(),
            sendSmsCodeDTO.getIp(), sendSmsCodeDTO.getTodayIndex(),
            sendSmsCodeDTO.getLastUserSmsCodeTime());
    // TODO 调用短信发送
    boolean hasSuccess = handler.sendSms(sendSmsCodeDTO.getMobile(), code);
    return hasSuccess;
  }

  /**
   * 验证短信码是否正确
   *
   * @param userVerifySmsCodeReqDTO
   */
  public boolean verifySmsCode(UserVerifySmsCodeReqDTO userVerifySmsCodeReqDTO) {
    return userSmsCodeService
        .verifySmsCode(userVerifySmsCodeReqDTO.getMobile(), userVerifySmsCodeReqDTO.getCode(),
            userVerifySmsCodeReqDTO.getLastSmsCodeId(), userVerifySmsCodeReqDTO.getIp(),
            userVerifySmsCodeReqDTO.getUsed());
  }

}
