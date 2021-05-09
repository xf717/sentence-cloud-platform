package com.db.chaomaxs.userservice.rpc.resume.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedAndStatusRespDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionIndustryCreateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.dto.UserExpectedPositionUpdateReqDTO;
import com.db.chaomaxs.userservice.rpc.resume.facade.UserExpectedPositionRpcFacade;
import java.util.ArrayList;
import java.util.List;
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
public class UserExpectedPositionRpcControllerTest extends TestCase {

  @Autowired
  private UserExpectedPositionRpcFacade userExpectedPositionRpcFacade;
  @Test
  public void getUserExpectedAndStatusByUserId() {
    ObjectRestResponse<UserExpectedAndStatusRespDTO> userExpectedAndStatusByUserId = userExpectedPositionRpcFacade
        .getUserExpectedAndStatusByUserId(1L);
    System.out.println(userExpectedAndStatusByUserId);
  }

  @Test
  public void save() {
    List<UserExpectedPositionIndustryCreateReqDTO> dtoList = new ArrayList<>();
    UserExpectedPositionIndustryCreateReqDTO dto = new UserExpectedPositionIndustryCreateReqDTO();
    dto.setIndustryId(1L).setIndustryName("互联网");
    dtoList.add(dto);
    UserExpectedPositionIndustryCreateReqDTO dto1 = new UserExpectedPositionIndustryCreateReqDTO();
    dto1.setIndustryId(2L).setIndustryName("金融");
    dtoList.add(dto1);

    UserExpectedPositionCreateReqDTO createReqDTO = new UserExpectedPositionCreateReqDTO();
    createReqDTO.setUserId(1L);
    createReqDTO.setCityCode("1");
    createReqDTO.setCityName("福州");
    createReqDTO.setPositionWantedStatusName("java");
    createReqDTO.setPositionWantedDictionaryId(10L);
    createReqDTO.setPositionTypeName("测试");
    createReqDTO.setPositionTypeId(2L);
    createReqDTO.setExpectedPositionIndustryList(dtoList);
    BaseResponse save = userExpectedPositionRpcFacade.save(createReqDTO);
    System.out.println(save);
  }

  @Test
  public void update() {
    UserExpectedPositionUpdateReqDTO updateReqDTO = new UserExpectedPositionUpdateReqDTO();
    updateReqDTO.setId(1381433314720997377L);
    updateReqDTO.setCityCode("1");
    updateReqDTO.setCityName("泉州");
    updateReqDTO.setEndSalary(1);
    updateReqDTO.setStartSalary(12);

    updateReqDTO.setPositionTypeName("测试");
    updateReqDTO.setPositionTypeId(2L);
    BaseResponse save = userExpectedPositionRpcFacade.update(updateReqDTO);
    System.out.println(save);
  }

  @Test
  public void remove() {
    userExpectedPositionRpcFacade.remove(1381436568741699586L);
  }
}