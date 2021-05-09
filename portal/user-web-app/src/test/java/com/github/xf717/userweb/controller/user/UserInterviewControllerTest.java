package com.github.xf717.userweb.controller.user;

import com.github.xf717.userweb.controller.user.dto.UserInterviewPageDTO;
import com.github.xf717.userweb.manager.user.UserInterviewManager;
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
public class UserInterviewControllerTest extends TestCase {

  @Autowired
  private UserInterviewManager userInterviewManager;
  @Test
  public void testPage() {
    UserInterviewPageDTO pageReqDTO = new UserInterviewPageDTO();
    pageReqDTO.setPageNo(1);
    pageReqDTO.setPageSize(10);
    userInterviewManager.pageUserInterview(pageReqDTO);
  }
}
