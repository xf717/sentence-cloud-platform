package com.db.chaomaxs.logservice.dao.sms;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import com.db.chaomaxs.logservice.dal.mysql.dataobject.sms.UserSmsCodeDO;
import com.db.chaomaxs.logservice.dal.mysql.mapper.sms.UserSmsCodeMapper;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserSmsCodeDaoTest
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/19 12:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional(rollbackFor = Exception.class)
@Rollback(true)
public class UserSmsCodeDaoTest {

  @Autowired
  private UserSmsCodeMapper userSmsCodeMapper;

  @Test
  public void testSelectLastByMobile() {
    UserSmsCodeDO userSmsCodeDO = userSmsCodeMapper.selectLastByMobile("13720895280", -1);
    assertNotNull(userSmsCodeDO);

    System.out.println("userSmsCodeDO===" + userSmsCodeDO);
  }

  @Test
  public void should_save_user_sms_code() {
    UserSmsCodeDO userSmsCodeDO = new UserSmsCodeDO().setMobile("13720895280").setCode("123456")
        .setScene(1).setTodayIndex(1).setCreateIp("192.168.0.13").setUsed(0)
        .setUsedTime(new Date())
        .setUsedIp("");
    userSmsCodeMapper.insert(userSmsCodeDO);
    assertNotNull(userSmsCodeDO.getId());
    assertThat(userSmsCodeDO.getId(), greaterThan(0L));
  }


}
