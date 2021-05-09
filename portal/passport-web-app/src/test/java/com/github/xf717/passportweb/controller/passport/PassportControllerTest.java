package com.github.xf717.passportweb.controller.passport;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.alibaba.fastjson.JSONObject;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.util.StringUtils;
import com.github.xf717.passportweb.controller.passport.dto.PassportLoginBySmsReqDTO;
import com.github.xf717.passportweb.controller.passport.dto.PassportSendSmsReqDTO;
import com.github.xf717.passportweb.controller.passport.vo.PassportTokenRespVO;
import com.github.xf717.passportweb.manager.passport.PassportManager;
import com.github.xf717.userservice.enums.sms.UserSmsSceneEnum;
import com.github.xf717.userservice.enums.user.LoginRegisterSourceEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * 求职_登录
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PassportController.class)
public class PassportControllerTest {


  @Autowired
  private MockMvc mockMvc;

  private String mobile;

  private String ip;

  @Before
  public void setup() throws Exception {
    mobile = "13720895280";
    ip = "192.168.1.180";
  }

  @Test
  public void testLoginBySms() throws Exception {
    PassportLoginBySmsReqDTO passportLoginBySmsReqDTO = new PassportLoginBySmsReqDTO();
    passportLoginBySmsReqDTO.setMobile("13720895280");
    passportLoginBySmsReqDTO.setCode("123456");
    passportLoginBySmsReqDTO
        .setLoginRegisterSource(LoginRegisterSourceEnum.USER.getValue());
    String ip = "192.168.0.133";
    PassportTokenRespVO passportTokenRespVO = this.passportTokenRespVO();
//    when(passportManager.loginBySms(passportLoginBySmsReqDTO, ip)).thenReturn(passportTokenRespVO);

    mockMvc.perform(post("/rest/passport/login-by-sms").contentType("application/json")
        .content(JSONObject.toJSONString(passportLoginBySmsReqDTO)))
        .andExpect(status().isOk())
        .andExpect(content().string("true"));
  }

  private PassportTokenRespVO passportTokenRespVO() {
    PassportTokenRespVO passportTokenRespVO = new PassportTokenRespVO();
    final String accessToke = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxMzcyMDg5NTI4MCIsInVzZXJJZCI6IjEiLCJuYW1lIjoiY2hhb21heHNfOTE2NTAiLCJpZCI6IlIzWExYbkx5IiwiZXhwIjoxNjE5NjgwNzc3fQ.iuioA8RjYqLgo0t7R7j3bamEBCFezkrzJ2uyxyEG2fSO9Mqxyk9ZN-utn8YYHbZo1zDryk0BhgMjyt2UwycT6Oxdu0TyJcb6hAcdPmPwHzjs4mvxKyOElvWspKLQhJFmY8PRyd0ycTGncZZEhVBej4IBwj3WwJ9qXBJoFWKTd0A";
    passportTokenRespVO.setAccessToken(accessToke);
    return passportTokenRespVO;
  }

  @Test
  public void testSendSmsCode() throws Exception {

    PassportSendSmsReqDTO passportSendSmsReqDTO = new PassportSendSmsReqDTO()
        .setMobile(mobile)
        .setScene(UserSmsSceneEnum.LOGIN_BY_SMS.getValue());
    passportSendSmsReqDTO
        .setLoginRegisterSource(LoginRegisterSourceEnum.USER.getValue());

//    when(passportManager.sendSmsCode(passportSendSmsReqDTO,ip)).thenReturn(Boolean.TRUE);

    mockMvc.perform(post("/rest/passport/send-sms-code").contentType("application/json")
        .content(JSONObject.toJSONString(passportSendSmsReqDTO)))
        .andExpect(status().isOk())
        .andExpect(content().json(JSONObject.toJSONString(ObjectRestResponse.success(true))));

  }


}
