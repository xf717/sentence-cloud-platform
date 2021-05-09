package com.db.chaomaxs.userweb.client.sms;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeRespDTO;
import com.db.chaomaxs.logservice.rpc.sms.facade.UserSmsCodeRpcFacade;
import com.db.chaomaxs.userservice.enums.sms.UserSmsSceneEnum;
import com.db.chaomaxs.userservice.rpc.sms.dto.UserVerifySmsCodeReqDTO;
import com.db.chaomaxs.userservice.rpc.sms.facade.SmsCodeRpcFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 验证短信
 * <p>因为短信是属于第三方,所以业务当成是第三方处理</p>
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/13 14:45
 */
@Service
public class VerifySmsCodeClient {

  @Autowired
  private UserSmsCodeRpcFacade userSmsCodeRpcFacade;

  @Autowired
  private SmsCodeRpcFacade smsCodeRpcFacade;

  /**
   * 统一的验证码验证处理
   *
   * @param mobile
   * @param code
   * @param ip
   * @param userSmsSceneEnum
   * @return
   */
  public boolean verifySmsCode(String mobile, String code, String ip,
      UserSmsSceneEnum userSmsSceneEnum) {
    // 查询场景验证码
    ObjectRestResponse<UserSmsCodeRespDTO> objectRestResponse = userSmsCodeRpcFacade
        .getLastCodeByMobile(mobile, userSmsSceneEnum.getValue());
    objectRestResponse.checkError();
    UserVerifySmsCodeReqDTO userVerifySmsCode = new UserVerifySmsCodeReqDTO()
        .setMobile(mobile)
        .setCode(code)
        .setIp(ip)
        .setScene(userSmsSceneEnum.getValue())
        .setLastSmsCodeId(objectRestResponse.getData().getId())
        .setUsed(objectRestResponse.getData().getUsed());
    ObjectRestResponse<Boolean> verifySmsCodeResponse = smsCodeRpcFacade
        .verifySmsCode(userVerifySmsCode);
    verifySmsCodeResponse.checkError();
    return verifySmsCodeResponse.getData();
  }

}
