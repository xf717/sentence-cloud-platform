package com.db.chaomaxs.logservice.rpc.sms.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.util.mapper.JsonMapper;
import com.db.chaomaxs.logservice.rpc.sms.UserSmsCodeRpcImpl;
import com.db.chaomaxs.logservice.rpc.sms.dto.UserSmsCodeRespDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * UserSmsCodeRpcControllerTest
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/20 11:13
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserSmsCodeRpcController.class)
public class UserSmsCodeRpcControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private UserSmsCodeRpcImpl userSmsCodeRpc;

  @Test
  public void testSelectLastByMobile() throws Exception {
    String mobile = "13720895280";

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
    final String result = JsonMapper.INSTANCE.toJson(objectRestResponse);
    System.out.println("result==" + result);
    when(userSmsCodeRpc.getLastCodeByMobile(mobile, 1)).thenReturn(objectRestResponse);

    mockMvc.perform(
        get("/facade/userSmsCode/mobile/last/code").param("mobile", mobile).param("scene", "1"))
        .andExpect(status().isOk());
//        .andExpect(content().json(JsonMapper.INSTANCE.toJson(objectRestResponse)));
  }


}
