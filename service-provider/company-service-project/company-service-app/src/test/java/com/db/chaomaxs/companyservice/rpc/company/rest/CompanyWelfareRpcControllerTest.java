package com.db.chaomaxs.companyservice.rpc.company.rest;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareSaveReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.CompanyWelfareRpcFacade;
import com.google.common.collect.Lists;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CompanyWelfareRpcControllerTest {

  @Autowired
  private CompanyWelfareRpcFacade companyWelfareRpcFacade;

  @Test
  public void customTypeSave() {
    CompanyWelfareCreateReqDTO companyWelfareCreateReqDTO = new CompanyWelfareCreateReqDTO();
    companyWelfareCreateReqDTO.setName("五险");
    companyWelfareCreateReqDTO.setCompanyId(2L);
    companyWelfareCreateReqDTO.setIconUrl("");
    companyWelfareCreateReqDTO.setWelfareType(0);
    companyWelfareCreateReqDTO.setChoose(0);
    companyWelfareRpcFacade.customTypeSave(companyWelfareCreateReqDTO);
  }

  @Test
  public void remove() {
    companyWelfareRpcFacade.remove(20L);
  }

  @Test
  public void getWelfareType() {
    ObjectRestResponse<List<CompanyWelfareRespDTO>> objectRestResponse = companyWelfareRpcFacade.listWelfareTypes(2L);
    objectRestResponse.getData();
  }

  @Test
  public void saveChooseWelfare() {
    List<CompanyWelfareSaveReqDTO> list = Lists.newArrayList();
    CompanyWelfareSaveReqDTO companyWelfareSaveReqDTO = new CompanyWelfareSaveReqDTO();
    companyWelfareSaveReqDTO.setId(160L);
    companyWelfareSaveReqDTO.setCompanyId(2L);
    companyWelfareSaveReqDTO.setParentId(2L);
    companyWelfareSaveReqDTO.setWelfareType(0);
    list.add(companyWelfareSaveReqDTO);

    companyWelfareSaveReqDTO = new CompanyWelfareSaveReqDTO();
    companyWelfareSaveReqDTO.setId(161L);
    companyWelfareSaveReqDTO.setCompanyId(2L);
    companyWelfareSaveReqDTO.setParentId(3L);
    companyWelfareSaveReqDTO.setWelfareType(0);
    list.add(companyWelfareSaveReqDTO);

    companyWelfareSaveReqDTO = new CompanyWelfareSaveReqDTO();
    companyWelfareSaveReqDTO.setId(20L);
    companyWelfareSaveReqDTO.setCompanyId(2L);
    companyWelfareSaveReqDTO.setParentId(0L);
    companyWelfareSaveReqDTO.setWelfareType(1);
    list.add(companyWelfareSaveReqDTO);

    companyWelfareRpcFacade.saveChooseWelfare(list);
  }
}