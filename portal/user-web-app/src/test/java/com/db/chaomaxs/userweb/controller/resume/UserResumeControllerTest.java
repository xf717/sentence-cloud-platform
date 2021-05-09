package com.db.chaomaxs.userweb.controller.resume;

import com.db.chaomaxs.userweb.controller.resume.vo.UserResumeVO;
import com.db.chaomaxs.userweb.manager.resume.UserResumeManager;
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
public class UserResumeControllerTest extends TestCase {

  @Autowired
  private UserResumeManager userResumeManager;

  @Test
  public void getUserResumeById() {
    UserResumeVO vo = userResumeManager.getUserResumeByUserId();
    System.out.println(vo);
  }
}