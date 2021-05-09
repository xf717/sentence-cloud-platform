package com.github.xf717.userservice.manager;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import com.github.xf717.common.framework.util.StringUtils;
import com.github.xf717.userservice.enums.user.GenderEnum;
import com.github.xf717.userservice.enums.user.LoginRegisterSourceEnum;
import com.github.xf717.userservice.enums.user.ThirdPartyLoginTypeEnum;
import com.github.xf717.userservice.enums.user.UserLoginTypeEnum;
import com.github.xf717.userservice.manager.user.UserInfoManager;
import com.github.xf717.userservice.rpc.user.dto.UserInfoCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserInfoRespDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserInfoManagerTest
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/23 15:02
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoManagerTest {

  @Autowired
  private UserInfoManager userInfoManager;

  private String mobile = "13720895280";

  private String ip = "192.168.0.133";


  @Test
  public void testCreateUserIfAbsent() {
    UserInfoCreateReqDTO userInfoCreateReqDTO = this.loginByThirdParty();
    UserInfoRespDTO userInfoRespDTO = userInfoManager.createUserIfAbsent(userInfoCreateReqDTO);
    assertNotNull(userInfoRespDTO);
    assertThat(userInfoRespDTO.getId(), greaterThan(0L));
  }

  private UserInfoCreateReqDTO loginBySms() {
    UserInfoCreateReqDTO userInfoCreate = new UserInfoCreateReqDTO()
        .setLoginRegisterSource(LoginRegisterSourceEnum.USER.getValue())
        .setUserLoginType(UserLoginTypeEnum.LOGIN_BY_SMS.getValue())
        .setMobile(mobile)
        .setRegisterIp(ip);
    return userInfoCreate;
  }

  private UserInfoCreateReqDTO loginByThirdParty() {
    UserInfoCreateReqDTO userInfoCreate = new UserInfoCreateReqDTO()
        .setLoginRegisterSource(LoginRegisterSourceEnum.USER.getValue())
        .setUserLoginType(UserLoginTypeEnum.LOGIN_BY_THIRD_PARTY.getValue())
        .setThirdType(ThirdPartyLoginTypeEnum.SMALL_ROUTINE.getValue())
        .setThirdIden(StringUtils.uuid(true))
        .setMobile(mobile)
        .setRegisterIp(ip)
        .setNickname(StringUtils.uuid(true))
        .setAvatarUrl(
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=91016227,2090420577&fm=26&gp=0.jpg")
        .setGender(GenderEnum.UNKNOWN.getValue());
    return userInfoCreate;
  }

  private UserInfoRespDTO userInfoResp() {
    UserInfoRespDTO userInfoRespDTO = new UserInfoRespDTO()
        .setId(1L)
        .setMobile(mobile)
        .setNickname("测试数据");
    return userInfoRespDTO;
  }

  @Test
  public void testVerifyPassword() {
    UserInfoRespDTO userInfoRespDTO = userInfoManager.verifyPassword(mobile, "123456");
    assertNotNull(userInfoRespDTO);
  }

  @Test
  public void testUpdateMobile() {
    boolean result = this.userInfoManager.updateMobile("13720895211", "13720895280");
    assertEquals(result, Boolean.TRUE);
  }

  @Test
  public void testSetPassword() {
    boolean result = this.userInfoManager.setPassword("13720895281", "123456");
    assertEquals(result, Boolean.TRUE);
  }

  @Test
  public void testupdatePassword() {
    boolean result = this.userInfoManager.updatePassword("13720895280", "123456", "12345678");
    assertEquals(result, Boolean.TRUE);
  }

}
