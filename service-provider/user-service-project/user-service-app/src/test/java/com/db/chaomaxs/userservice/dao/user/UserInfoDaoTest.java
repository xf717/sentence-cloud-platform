package com.db.chaomaxs.userservice.dao.user;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import com.db.chaomaxs.common.framework.enums.CommonStatusEnum;
import com.db.chaomaxs.common.framework.util.StringUtils;
import com.db.chaomaxs.common.framework.util.password.Sha256PasswordEncoder;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserExtendDO;
import com.db.chaomaxs.userservice.dal.mysql.dataobject.user.UserInfoDO;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserExtendMapper;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserInfoMapper;
import com.db.chaomaxs.userservice.dal.mysql.mapper.user.UserThirdMapper;
import com.db.chaomaxs.userservice.enums.user.GenderEnum;
import com.db.chaomaxs.userservice.enums.user.IdentityTypeEnum;
import com.db.chaomaxs.userservice.enums.user.RegisterTypeEnum;
import com.db.chaomaxs.userservice.enums.user.TerminalTypeEnum;
import com.db.chaomaxs.userservice.enums.user.UserRoleEnum;
import com.db.chaomaxs.userservice.enums.user.UserStatusEnum;
import com.db.chaomaxs.userservice.enums.user.UserTypeEnum;
import com.db.chaomaxs.userservice.rpc.user.dto.UserInfoListQueryReqDTO;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserInfoDaoTest
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/16 11:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional(rollbackFor = Exception.class)
@Rollback(true)
public class UserInfoDaoTest {

  @Autowired
  private UserInfoMapper userInfoMapper;

  @Autowired
  private UserExtendMapper userExtendMapper;

  @Autowired
  private UserThirdMapper userThirdMapper;

  private Sha256PasswordEncoder encoder = new Sha256PasswordEncoder();

  @Test
  public void testCreateUser() {
    UserInfoDO userInfoDO = createUserInfo();
    assertNotNull(userInfoDO.getId());
    assertThat(userInfoDO.getId(), greaterThan(0L));

  }

  private UserInfoDO createUserInfo() {
    UserInfoDO userInfoDO = new UserInfoDO();
    // 默认初始化一个昵称
    final String nickname = "chaomaxs_" + StringUtils.uuid(false);
    userInfoDO
        .setMobile("13720895280")
        .setPassword(encoder.encode(StringUtils.uuid(false)))
        .setUserStatus(UserStatusEnum.NORMAL.getValue())
        .setNickname(nickname)
        .setSignature("")
        .setAvatarUrl(" ")
        .setUserStatus(UserStatusEnum.NORMAL.getValue())
        .setUserType(UserTypeEnum.ORDINARY_USER.getValue());
    userInfoMapper.insert(userInfoDO);
    return userInfoDO;
  }

  @Test
  public void testCreateUserExtend() {
    UserExtendDO userExtendDO = this.createUserExtend("192.168.0.133", 1L);
    assertNotNull(userExtendDO.getId());
    assertThat(userExtendDO.getId(), greaterThan(0L));
  }

  private UserExtendDO createUserExtend(String ip, Long userId) {
    final String defaultEmail = "chaomax_" + userId + "@126.com";
    UserExtendDO userExtendDO = new UserExtendDO().setUserId(userId)
        .setEmail(defaultEmail).setWeixin("").setGender(GenderEnum.UNKNOWN.getValue())
        .setRealName("").setIdcard(StringUtils.generateRandomCode(10)).setCompanyName("")
        .setRegisterTime(new Date()).setUserRole(UserRoleEnum.USER.getValue()).setIdentityType(
            IdentityTypeEnum.WORKPLACE.getValue())
        .setEnabledGreet(CommonStatusEnum.ENABLE.getValue())
        .setEnabledInterviewNotice(CommonStatusEnum.ENABLE.getValue())
        .setEnabledHide(CommonStatusEnum.DISABLE.getValue())
        .setRegisterIp(ip).setRegisterType(RegisterTypeEnum.MOBILE.getValue())
        .setExpireFreeze(new Date()).setFreezeReason("")
        .setTerminalType(TerminalTypeEnum.WEB.getValue()).setTerminalSn("").setTerminalName("");

    int result = this.userExtendMapper.insert(userExtendDO);
    assertEquals(result, 1);
    return userExtendDO;
  }



  @Test
  public void testSelectList() {

    List<UserInfoDO> listAll = userInfoMapper.selectList(new UserInfoListQueryReqDTO());
    assertEquals(2, listAll.size());
  }

  @Test
  public void testSelectMobile() {
    UserInfoDO userInfo = userInfoMapper.selectByMobile("13134745641");
    assertNotNull(userInfo);

    System.out.println(userInfo);
  }


}
