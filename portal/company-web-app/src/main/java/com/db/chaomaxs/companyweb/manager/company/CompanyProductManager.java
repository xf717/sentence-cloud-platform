package com.db.chaomaxs.companyweb.manager.company;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.CompanyProductRpcFacade;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyProductAddDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyProductVO;
import com.db.chaomaxs.companyweb.convert.company.CompanyProductConvert;
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
  private CompanyProductRpcFacade companyProductRpcFacade;

  /**
   * 保存公司产品信息
   *
   * @param companyProductAddDTOs 添加参数
   * @return
   */
  public void save(List<CompanyProductAddDTO> companyProductAddDTOs) {
    companyProductAddDTOs.forEach(v -> v.setCompanyId(BaseContextHandler.getCompanyId()));
    companyProductRpcFacade.save(CompanyProductConvert.INSTANCE.convertToCreateReqDTO(companyProductAddDTOs));
  }

  /**
   * 获取公司所有产品
   * @return
   */
  public List<CompanyProductVO> listProducts() {
    ObjectRestResponse<List<CompanyProductRespDTO>> objectRestResponse = companyProductRpcFacade
        .listProducts(BaseContextHandler.getCompanyId());
    objectRestResponse.checkError();
    return CompanyProductConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

}
