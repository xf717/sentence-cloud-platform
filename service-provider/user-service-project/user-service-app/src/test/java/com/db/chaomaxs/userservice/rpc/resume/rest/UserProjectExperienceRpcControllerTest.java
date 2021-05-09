package com.db.chaomaxs.userservice.rpc.resume.rest;

import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserProjectExperienceUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.facade.UserProjectExperienceRpcFacade;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class UserProjectExperienceRpcControllerTest extends TestCase {

  @Autowired
  private UserProjectExperienceRpcFacade userProjectExperienceRpcFacade;

  @Test
  public void save() throws ParseException {
    UserProjectExperienceCreateReqDTO createReqDTO = new UserProjectExperienceCreateReqDTO();
    SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM");
    createReqDTO.setDescription("测试工作经验");
    createReqDTO.setStartTime( sf.parse("2018-07"));
    createReqDTO.setEndTime( sf.parse("2020-07"));
    createReqDTO.setProjectName("超级码场");
    createReqDTO.setUserResumeId(1L);
    userProjectExperienceRpcFacade.save(createReqDTO);
  }

  @Test
  public void update() {
    UserProjectExperienceUpdateReqDTO updateReqDTO = new UserProjectExperienceUpdateReqDTO();
    updateReqDTO.setId(1381492728471576578L);
    updateReqDTO.setDescription("ceshiceshiceshi");
    userProjectExperienceRpcFacade.update(updateReqDTO);
  }

  @Test
  public void remove() {
    userProjectExperienceRpcFacade.remove(1381492728471576578L);
  }
}