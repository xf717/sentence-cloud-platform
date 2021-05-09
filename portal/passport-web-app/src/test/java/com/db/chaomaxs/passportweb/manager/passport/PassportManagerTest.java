package com.db.chaomaxs.passportweb.manager.passport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeRespDTO;
import com.db.chaomaxs.passportweb.controller.passport.dto.PassportLoginBySmsReqDTO;
import com.db.chaomaxs.passportweb.controller.passport.dto.PassportSendSmsReqDTO;
import com.db.chaomaxs.passportweb.controller.passport.vo.PassportTokenRespVO;
import com.db.chaomaxs.userservice.enums.sms.UserSmsSceneEnum;
import com.db.chaomaxs.userservice.enums.user.LoginRegisterSourceEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PassportManagerTest
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/16 11:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PassportManagerTest {

  @Autowired
  private PassportManager passportManager;

  private String mobile;

  private String ip;

  @Before
  public void setup() throws Exception {
    mobile = "13720895280";
    ip = "192.168.1.133";
  }

  @Test
  public void testSendSmsCode() {
    PassportSendSmsReqDTO passportSendSmsReqDTO = this.createPassportSendSmsReq();
    ObjectRestResponse<UserSmsCodeRespDTO> objectRestResponse = this.createMockUserSmsCodeResp();
//    when(userSmsCodeRpcFacade
//        .getLastCodeByMobile("13720895280", UserSmsSceneEnum.LOGIN_BY_SMS.getValue()))
//        .thenReturn(objectRestResponse);
    boolean result = passportManager.sendSmsCode(passportSendSmsReqDTO, "192.168.0.180");
    assertEquals(result, Boolean.TRUE);
  }

  private PassportSendSmsReqDTO createPassportSendSmsReq() {
    PassportSendSmsReqDTO passportSendSmsReqDTO = new PassportSendSmsReqDTO()
        .setMobile("13720895280")
        .setScene(UserSmsSceneEnum.LOGIN_BY_SMS.getValue());
    passportSendSmsReqDTO
        .setLoginRegisterSource(LoginRegisterSourceEnum.USER.getValue());
    return passportSendSmsReqDTO;
  }

  private ObjectRestResponse<UserSmsCodeRespDTO> createMockUserSmsCodeResp() {
    UserSmsCodeRespDTO userSmsCodeRespDTO = new UserSmsCodeRespDTO()
        .setId(4L)
        .setMobile("13720895280")
        .setCode("309924")
        .setScene(1)
        .setTodayIndex(1)
        .setUsed(0).setCreateTime(null)
        .setUsedTime(null);

//    {"code":200,"message":"","detailMessage":null,"data":{"id":4,"mobile":"13720895280","code":"309924","scene":1,"todayIndex":1,"used":null,"usedTime":1618830784000,"createTime":1618830785000},"error":false,"success":true}
    ObjectRestResponse<UserSmsCodeRespDTO> objectRestResponse = ObjectRestResponse
        .success(userSmsCodeRespDTO);
    return objectRestResponse;
  }

  @Test
  public void testLoginBySms() {
    PassportLoginBySmsReqDTO passportLoginBySmsReqDTO = new PassportLoginBySmsReqDTO()
        .setMobile(mobile).setCode("949227");
    passportLoginBySmsReqDTO.setLoginRegisterSource(LoginRegisterSourceEnum.USER.getValue());
    PassportTokenRespVO passportTokenResp = this.passportManager
        .loginBySms(passportLoginBySmsReqDTO, ip);

    assertNotNull(passportTokenResp);
    assertNotNull(passportTokenResp.getAccessToken());

  }

}
