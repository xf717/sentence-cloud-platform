package com.db.chaomaxs.userweb.service.sms;

import com.db.chaomaxs.userservice.enums.sms.UserSmsSceneEnum;
import com.db.chaomaxs.userweb.client.sms.VerifySmsCodeClient;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 为了层级更加清晰，在做一层业务操作
 * <p>根据阿里分层规范在进行一层service 处理</p>
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/13 18:19
 */
@Service
public class VerifySmsCodeService {

  @Resource
  private VerifySmsCodeClient verifySmsCodeClient;

  public boolean verifySmsCode(String mobile, String code, String ip,
      UserSmsSceneEnum userSmsSceneEnum) {
    return verifySmsCodeClient.verifySmsCode(mobile, code, ip, userSmsSceneEnum);
  }

}
