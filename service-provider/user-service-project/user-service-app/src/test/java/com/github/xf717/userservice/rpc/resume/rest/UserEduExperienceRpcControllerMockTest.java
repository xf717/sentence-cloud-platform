package com.github.xf717.userservice.rpc.resume.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.util.mapper.JsonMapper;
import com.github.xf717.userservice.rpc.resume.UserEduExperienceRpcImpl;
import com.github.xf717.userservice.rpc.resume.dto.UserEduExperienceRespDTO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserEduExperienceRpcController.class)
@Ignore
public class UserEduExperienceRpcControllerMockTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private UserEduExperienceRpcImpl userEduExperienceRpc;

  @Test
  public void testGetLastStepByUserId() throws Exception {

    UserEduExperienceRespDTO userEduExperienceRespDTO = new UserEduExperienceRespDTO()
        .setUserResumeId(1L)
        .setEducation("本科")
        .setEducationDictionaryId(1L)
        .setSchoolId(1L)
        .setSchoolName("xxx小学")
        .setSpecialityId(2L)
        .setSpecialityName("计算机");
    ObjectRestResponse<UserEduExperienceRespDTO> objectRestResponse = ObjectRestResponse
        .success(userEduExperienceRespDTO);

    final String result = JsonMapper.INSTANCE.toJson(objectRestResponse);
    System.out.println("result==" + result);
    when(userEduExperienceRpc.getLastStepByUserId(1L)).thenReturn(objectRestResponse);

    mockMvc.perform(get("/facade/userEduExperience/get/last/step/1"))
        .andExpect(status().isOk());
  }

}
