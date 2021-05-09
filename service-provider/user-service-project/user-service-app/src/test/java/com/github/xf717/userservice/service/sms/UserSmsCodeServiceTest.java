package com.github.xf717.userservice.service.sms;

import com.github.xf717.userservice.enums.sms.UserSmsSceneEnum;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserSmsCodeServiceTest
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/19 12:04
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserSmsCodeServiceTest {

  @Autowired
  private UserSmsCodeService userSmsCodeService;

  @Test
  public void testCreateSmsCode() {
    String mobile = "13720895280";
    Integer scene = UserSmsSceneEnum.LOGIN_BY_SMS.getValue();
    String ip = "192.168.0.13";
    Integer todayIndex = 1;
    String code = userSmsCodeService.createSmsCode(mobile, scene, ip, todayIndex, new Date());
    System.out.println(code);
  }


}
