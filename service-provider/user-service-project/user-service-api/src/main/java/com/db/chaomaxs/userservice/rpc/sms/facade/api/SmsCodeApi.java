package com.db.chaomaxs.userservice.rpc.sms.facade.api;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.userservice.rpc.sms.dto.UserSendSmsCodeReqDTO;
import com.db.chaomaxs.userservice.rpc.sms.dto.UserVerifySmsCodeReqDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_黑名单
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
public interface SmsCodeApi {

  /**
   * 发送短信验证码
   *
   * @param sendSmsCodeDTO
   * @return
   */
  @PostMapping("/facade/sms/send/code")
  ObjectRestResponse<Boolean> sendSmsCode(@RequestBody UserSendSmsCodeReqDTO sendSmsCodeDTO);

  /**
   * 短信校验
   *
   * @param verifySmsCodeDTO
   * @return
   */
  @PostMapping("/facade/sms/code/verify")
  ObjectRestResponse<Boolean> verifySmsCode(@RequestBody UserVerifySmsCodeReqDTO verifySmsCodeDTO);

}
