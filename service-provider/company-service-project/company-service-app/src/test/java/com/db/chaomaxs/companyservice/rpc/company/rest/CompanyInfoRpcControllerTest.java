package com.db.chaomaxs.companyservice.rpc.company.rest;


import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.CompanyInfoRpcFacade;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class CompanyInfoRpcControllerTest {

  @Autowired
  private CompanyInfoRpcFacade companyInfoRpcFacade;

  @Test
  public void getCompanyInfoByCompanyName() {
    String companyName = "秦商科技";
    ObjectRestResponse<CompanyInfoRespDTO> objectRestResponse = companyInfoRpcFacade.getCompanyInfoByCompanyName(companyName);
    objectRestResponse.getData();
  }

  @Test
  public void save() {
    companyInfoRpcFacade.save(new CompanyInfoCreateReqDTO()
            .setFullName("超级码场")
            .setAddress("软件园二期34号之一301G")
            .setProvinceCode("350000").setProvinceName("福建省")
            .setCityCode("350200").setCityName("厦门市")
            .setAreaCode("350203").setAreaName("思明区")
            .setDevelopmentStageDictionaryId(25L)
            .setIndustryId(1L).setIndustryName("")
            .setEnabled(1).setLicenseUrl("")
            .setUserId(1L).setScopeDictionaryId(20L)
            .setShortName("chaomax").setStartWorkTime("08:30")
            .setEndWorkTime("18:00").setLogoUrl("").setIntro(""));
  }

  @Test
  public void update() {
    companyInfoRpcFacade.update(new CompanyInfoUpdateReqDTO()
            .setId(2L)
            .setFullName("超级码场")
            .setAddress("软件园二期34号之一301G")
            .setProvinceCode("350000").setProvinceName("福建省")
            .setCityCode("350200").setCityName("厦门市")
            .setAreaCode("350203").setAreaName("思明区")
            .setDevelopmentStageDictionaryId(24L)
            .setIndustryId(2L).setIndustryName("")
            .setLicenseUrl("").setRestTimeDictionaryId(31L).setWorkOvertimeDictionaryId(35L)
            .setUserId(1L).setScopeDictionaryId(18L).setIntro("简介")
            .setShortName("chaomax").setStartWorkTime("08:30")
            .setEndWorkTime("18:30").setLogoUrl(""));
    System.out.println(1);
  }
}