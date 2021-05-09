package com.db.chaomaxs.userservice.rpc.user.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.userservice.rpc.user.dto.UserExtendUpdateEnableHideReqDTO;
import com.db.chaomaxs.userservice.rpc.user.facade.UserExtendRpcFacade;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserExtendRpcControllerTest extends TestCase {

  @Autowired
  private UserExtendRpcFacade userExtendRpcFacade;
  @Test
  public void updateEnableHideDTO() {

    UserExtendUpdateEnableHideReqDTO dto = new UserExtendUpdateEnableHideReqDTO();
    dto.setUserId(2L);
    dto.setEnabledHide(1);
    dto.setEnabledGreet(1);
    dto.setEnabledInterviewNotice(1);
    BaseResponse response = userExtendRpcFacade.updateEnableHideDTO(dto);
    System.out.println(response);


  }
}