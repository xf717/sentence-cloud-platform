package com.github.xf717.userservice.rpc.resume.rest;

import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserWorkExperienceUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.facade.UserWorkExperienceRpcFacade;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class UserWorkExperienceRpcControllerTest extends TestCase {

  @Autowired
  private UserWorkExperienceRpcFacade userWorkExperienceRpcFacade;

  @Test
  public void testSave() {
    List<String> list = Arrays.asList("spring", "sss", "vvv");
    UserWorkExperienceCreateReqDTO createReqDTO = new UserWorkExperienceCreateReqDTO();
    createReqDTO.setUserId(1L)
        .setCompanyName("秦商")
        .setContent("测试")
        .setPositionName("qa")
        .setPositionTypeId(1L)
        .setIndustryId(1L)
        .setIndustryName("互联网")
        .setPositionTypeName("java")
        .setStartJobTime(2020)
        .setQuitJobTime(2021)
        .setWorkSkillTagList(list);
    userWorkExperienceRpcFacade.save(createReqDTO);

  }

  @Test
  public void testUpdate() {
    List<String> list = Arrays.asList("vue", "done", "go");
    UserWorkExperienceUpdateReqDTO userWorkExperienceUpdateReqDTO = new UserWorkExperienceUpdateReqDTO();
    userWorkExperienceUpdateReqDTO.setId(1381508893981831172L);
    userWorkExperienceUpdateReqDTO.setCompanyName("大包信息科技");
    userWorkExperienceUpdateReqDTO.setQuitJobTime(2021);
    userWorkExperienceUpdateReqDTO.setStartJobTime(1999);
    userWorkExperienceUpdateReqDTO.setWorkSkillTagUpdateReqList(list);
    userWorkExperienceRpcFacade.update(userWorkExperienceUpdateReqDTO);
  }

  @Test
  public void testRemove() {
    userWorkExperienceRpcFacade.remove(1381508893981831172L);
  }

  @Test
  public void testGetLastStepByUserId() {
    userWorkExperienceRpcFacade.getLastStepByUserId(1381508893981831172L);
  }

}
