package com.db.chaomaxs.userservice.rpc.resume.rest;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserResumeRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.facade.UserResumeRpcFacade;
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
public class UserResumeRpcControllerTest  extends TestCase {

  @Autowired
  private UserResumeRpcFacade userResumeRpcFacade;


  @Test
  public void getUserResumeById(){
    ObjectRestResponse<UserResumeRespDTO> userResumeById = userResumeRpcFacade
        .getUserResumeById(1L);
    System.out.println(userResumeById);
  }

}