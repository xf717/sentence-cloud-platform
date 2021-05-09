package com.github.xf717.userservice.rpc.user.rest;

import com.github.xf717.userservice.dal.mysql.dataobject.user.UserRecruitExtendDO;
import com.github.xf717.userservice.enums.user.UserBindingStateEnum;
import com.github.xf717.userservice.rpc.user.dto.UserBindingCompanyCreateReqDTO;
import com.github.xf717.userservice.rpc.user.dto.UserBindingTransferReqDTO;
import com.github.xf717.userservice.rpc.user.facade.UserBindingCompanyRpcFacade;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class UserBindingCompanyRpcControllerTest extends TestCase {

  @Autowired
  private UserBindingCompanyRpcFacade userBindingCompanyRpcFacade;

  @Test
  public void save() {
    UserBindingCompanyCreateReqDTO dto = new UserBindingCompanyCreateReqDTO();
    dto.setId(1L);
    dto.setUserId(1L);
    dto.setManager(1);
    dto.setCompanyId(2L);
    dto.setBindingState(UserBindingStateEnum.BOUND.getValue());
    UserRecruitExtendDO userRecruitExtendDO = new UserRecruitExtendDO();
    userBindingCompanyRpcFacade.save(dto);
  }

  @Test
  public void handover() {
    UserBindingTransferReqDTO userBindingTransferReqDTO = new UserBindingTransferReqDTO();
    userBindingTransferReqDTO.setUserId(1L);
    userBindingTransferReqDTO.setTransferToUserId(2L);
    userBindingTransferReqDTO.setCompanyId(2L);
    userBindingCompanyRpcFacade.handover(userBindingTransferReqDTO);
  }
}
