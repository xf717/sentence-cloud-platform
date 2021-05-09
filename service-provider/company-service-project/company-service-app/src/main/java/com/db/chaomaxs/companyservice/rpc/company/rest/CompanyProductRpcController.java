package com.db.chaomaxs.companyservice.rpc.company.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.company.CompanyProductRpcImpl;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.api.CompanyProductApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公司_产品
 *
 * @author hlf
 * @date 2021-03-26 10:18:33
 */
@RestController
public class CompanyProductRpcController implements CompanyProductApi {

  @Autowired
  private CompanyProductRpcImpl companyProductRpc;

  @Override
  public BaseResponse save(@RequestBody List<CompanyProductCreateReqDTO> companyProductCreateReqDTOs) {
    return companyProductRpc.save(companyProductCreateReqDTOs);
  }

  @Override
  public ObjectRestResponse<CompanyProductRespDTO> getCompanyProductById(Long id) {
    return companyProductRpc.getCompanyProductById(id);
  }

  @Override
  public ObjectRestResponse<List<CompanyProductRespDTO>> listProducts(@RequestParam("id") Long companyId) {
    return companyProductRpc.listProducts(companyId);
  }
}
