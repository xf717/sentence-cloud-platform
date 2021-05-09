package com.db.chaomaxs.userservice.rpc.user.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.userservice.rpc.user.facade.UserIntegralRecordRpcFacade;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserIntegralRecordRpcControllerTest extends TestCase {

  @Autowired
  private UserIntegralRecordRpcFacade userIntegralRecordRpcFacade;
  @Test
  public void sign() {

    BaseResponse sign = userIntegralRecordRpcFacade.sign(2L);
    System.out.println(sign);
  }
}