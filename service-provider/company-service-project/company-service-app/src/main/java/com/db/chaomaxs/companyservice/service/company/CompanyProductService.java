package com.db.chaomaxs.companyservice.service.company;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.common.framework.util.CollectionUtils;
import com.db.chaomaxs.companyservice.convert.company.CompanyProductConvert;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.CompanyProductDO;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.company.CompanyProductMapper;
import com.db.chaomaxs.companyservice.enums.CompanyErrorCodeConstants;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductRespDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyProductService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class CompanyProductService {

  @Autowired
  private CompanyProductMapper companyProductMapper;

  /**
   * 保存数据
   *
   * @param createReqDTOs
   * @return
   */
  public void saveBatch(List<CompanyProductCreateReqDTO> createReqDTOs) {
    if (CollectionUtils.isEmpty(createReqDTOs)) {
      throw ServiceExceptionUtil.exception(CompanyErrorCodeConstants.PARAMETER_NULL.getCode());
    }
    Long companyId = createReqDTOs.stream().findFirst().orElse(null).getCompanyId();
    // 先删除公司原有数据
    companyProductMapper.deleteByCompanyId(companyId);
    // 再批量保存新数据
    companyProductMapper.batchInsert(CompanyProductConvert.INSTANCE.convert(createReqDTOs));
  }

  public CompanyProductRespDTO getById(Long id) {
    CompanyProductDO companyProductDO = companyProductMapper.selectById(id);
    if (null == companyProductDO) {
      throw ServiceExceptionUtil.exception(CompanyErrorCodeConstants.RESULT_NULL.getCode());
    }
    return CompanyProductConvert.INSTANCE.convert(companyProductDO);
  }

  /**
   * 获取公司产品
   *
   * @param companyId
   * @return
   */
  public List<CompanyProductRespDTO> listProducts(Long companyId) {
    if (null == companyId) {
      throw ServiceExceptionUtil.exception(CompanyErrorCodeConstants.PARAMETER_NULL.getCode());
    }
    List<CompanyProductDO> list = companyProductMapper.listProducts(companyId);
    if (CollectionUtils.isEmpty(list)) {
      return Collections.emptyList();
    }
    return CompanyProductConvert.INSTANCE.convertList(list);
  }


}
