package com.db.chaomaxs.passportweb.service.sms;

import static org.junit.Assert.assertEquals;

import com.db.chaomaxs.userservice.enums.sms.UserSmsSceneEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * VerifySmsCodeServiceTest
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/16 11:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VerifySmsCodeServiceTest {

  @Autowired
  private VerifySmsCodeService verifySmsCodeService;

  private String mobile;

  private String ip;

  @Before
  public void setup() throws Exception {
    mobile = "13720895280";
    ip = "192.168.1.180";
  }

  @Test
  public void testVerifySmsCode() {
    boolean result = verifySmsCodeService
        .verifySmsCode(mobile, "455339", ip, UserSmsSceneEnum.LOGIN_BY_SMS);
    assertEquals(result, Boolean.TRUE);
  }

}
