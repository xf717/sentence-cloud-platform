package com.db.chaomaxs.companyservice.manager.delivery;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryRespDTO;
import com.db.chaomaxs.companyservice.rpc.delivery.dto.CompanyDeliveryUpdateReqDTO;
import com.db.chaomaxs.companyservice.service.delivery.CompanyDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyDeliveryManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyDeliveryManager {

  @Autowired
  private CompanyDeliveryService companyDeliveryService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveCompanyDelivery(CompanyDeliveryCreateReqDTO createReqDTO) {
    return companyDeliveryService.saveCompanyDelivery(createReqDTO);
  }


  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public CompanyDeliveryRespDTO getCompanyDeliveryById(Long id) {
    return companyDeliveryService.getCompanyDeliveryById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<CompanyDeliveryRespDTO> pageCompanyDelivery(CompanyDeliveryPageReqDTO page) {
    return companyDeliveryService.pageCompanyDelivery(page);
  }


}
