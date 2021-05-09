package com.db.chaomaxs.userservice.rpc.resume.rest;

import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperienceCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserEduExperienceUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.facade.UserEduExperienceRpcFacade;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserEduExperienceRpcControllerTest extends TestCase {

  @Autowired
  private UserEduExperienceRpcFacade userEduExperienceRpcFacade;

  @Test
  public void save() throws ParseException {
    SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM");
    UserEduExperienceCreateReqDTO createReqDTO = new UserEduExperienceCreateReqDTO();
    createReqDTO.setUserId(1L);
    createReqDTO.setEducation("本科").setEducationDictionaryId(1L).setSchoolId(128L)
        .setSchoolName("xxx大学")
        .setSpecialityId(4L)
        .setSpecialityName("cccsss");
    userEduExperienceRpcFacade.save(createReqDTO);
  }

  @Test
  public void update() {
    UserEduExperienceUpdateReqDTO updateReqDTO = new UserEduExperienceUpdateReqDTO();
    updateReqDTO.setEducation("小学");
    updateReqDTO.setId(1L);
    updateReqDTO.setSchoolName("xxx小学");
    userEduExperienceRpcFacade.update(updateReqDTO);
  }

  @Test
  public void getLastStepByUserId() {
    userEduExperienceRpcFacade.getLastStepByUserId(2L);
  }
}