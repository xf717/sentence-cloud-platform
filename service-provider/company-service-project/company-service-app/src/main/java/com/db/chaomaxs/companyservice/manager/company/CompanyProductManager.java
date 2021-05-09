package com.db.chaomaxs.companyservice.manager.company;

import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductRespDTO;
import com.db.chaomaxs.companyservice.service.company.CompanyProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyProductManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyProductManager {

  @Autowired
  private CompanyProductService companyProductService;

  /**
   * 保存数据
   *
   * @param createReqDTOs
   * @return
   */
  public void saveBatch(List<CompanyProductCreateReqDTO> createReqDTOs) {
    companyProductService.saveBatch(createReqDTOs);
  }

  /**
   * 获取产品信息
   *
   * @param id
   * @return
   */
  public CompanyProductRespDTO getById(Long id) {
    return companyProductService.getById(id);
  }

  /**
   * 获取公司产品信息
   *
   * @param companyId
   * @return
   */
  public List<CompanyProductRespDTO> listProducts(Long companyId) {
    return companyProductService.listProducts(companyId);
  }

}
