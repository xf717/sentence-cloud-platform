package com.db.chaomaxs.companyservice.rpc.company;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.manager.company.CompanyProductManager;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.CompanyProductRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @data 2021-03-26 10:18:33
 */
@Slf4j
@Service
public class CompanyProductRpcImpl implements CompanyProductRpcFacade {

  @Autowired
  private CompanyProductManager companyProductManager;

  @Override
  public BaseResponse save(List<CompanyProductCreateReqDTO> companyProductCreateReqDTOs) {
    companyProductManager.saveBatch(companyProductCreateReqDTOs);
    return BaseResponse.success("保存成功");
  }

  @Override
  public ObjectRestResponse<CompanyProductRespDTO> getCompanyProductById(Long id) {
    return ObjectRestResponse.success(companyProductManager.getById(id));
  }

  @Override
  public ObjectRestResponse<List<CompanyProductRespDTO>> listProducts(Long companyId) {
    return ObjectRestResponse.success(companyProductManager.listProducts(companyId));
  }

}
