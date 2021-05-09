package com.db.chaomaxs.companyservice.rpc.company.rest;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.CompanyProductRpcFacade;
import com.google.common.collect.Lists;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class CompanyProductRpcControllerTest {

  @Autowired
  private CompanyProductRpcFacade companyProductRpcFacade;

  @Test
  public void save() {
    List<CompanyProductCreateReqDTO> list = Lists.newArrayList();
    CompanyProductCreateReqDTO dto = new CompanyProductCreateReqDTO();
    dto.setCompanyId(2L);
    dto.setLogoUrl("");
    dto.setProductName("微信");
    list.add(dto);

    companyProductRpcFacade.save(list);
  }

  @Test
  public void getCompanyProducts() {

    ObjectRestResponse<List<CompanyProductRespDTO>> companyProducts = companyProductRpcFacade.listProducts(2L);
    companyProducts.getData();
  }
}