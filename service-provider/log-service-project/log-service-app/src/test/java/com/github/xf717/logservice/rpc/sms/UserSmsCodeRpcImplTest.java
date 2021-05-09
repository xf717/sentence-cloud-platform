package com.github.xf717.logservice.rpc.sms;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.util.mapper.JsonMapper;
import com.github.xf717.logservice.rpc.sms.dto.UserSmsCodeRespDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserSmsCodeRpcImplTest
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/20 9:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSmsCodeRpcImplTest {

  @Autowired
  private UserSmsCodeRpcImpl userSmsCodeRpc;

  @Test
  public void testSelectLastByMobile() {
//    UserSmsCodeRespDTO userSmsCodeRespDTO = userSmsCodeManager
//        .getLastCodeByMobile("13720895280", 1);
//
//    assertNotNull(userSmsCodeRespDTO.getId());
//    assertThat(userSmsCodeRespDTO.getId(), greaterThan(0L));
    ObjectRestResponse<UserSmsCodeRespDTO> objectRestResponse = userSmsCodeRpc
        .getLastCodeByMobile("13720895280", 1);
    assertNotNull(objectRestResponse.getData().getId());
    assertThat(objectRestResponse.getData().getId(), greaterThan(0L));
    final String result = JsonMapper.INSTANCE.toJson(objectRestResponse);
    System.out.println("result==" + result);
  }


}
