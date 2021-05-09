package com.db.chaomaxs.companyservice.service.company;

import com.db.chaomaxs.common.framework.exception.util.ServiceExceptionUtil;
import com.db.chaomaxs.companyservice.convert.company.CompanyPhotoConvert;
import com.db.chaomaxs.companyservice.dal.mysql.dataobject.company.CompanyPhotoDO;
import com.db.chaomaxs.companyservice.dal.mysql.mapper.company.CompanyPhotoMapper;
import com.db.chaomaxs.companyservice.enums.CompanyErrorCodeConstants;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoSaveReqDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyPhotoService
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/21 21:20
 */
@Service
@Validated
public class CompanyPhotoService {

  @Autowired
  private CompanyPhotoMapper companyPhotoMapper;

  /**
   * 保存数据
   * @param companyPhotoSaveReqDTO
   */
  public void saveBatch(CompanyPhotoSaveReqDTO companyPhotoSaveReqDTO) {
    // 先根据companyId删除公司相册数据
    companyPhotoMapper.deleteByCompanyId(companyPhotoSaveReqDTO.getCompanyId());
    // 再添加新相册数据
    companyPhotoMapper.batchInsert(CompanyPhotoConvert.INSTANCE.convertCompanyPhotoDOs(
        companyPhotoSaveReqDTO.getCompanyPhotoReqDTOS()));
  }

  /**
   * 获取公司相册
   * @param companyId
   * @return
   */
  public List<CompanyPhotoRespDTO> getByCompanyId(Long companyId) {
    if (null == companyId) {
      throw ServiceExceptionUtil
          .exception(CompanyErrorCodeConstants.PARAMETER_NULL.getCode());
    }
    List<CompanyPhotoDO> companyPhotoDOs = companyPhotoMapper.selectByCompanyId(companyId);
    return CompanyPhotoConvert.INSTANCE.convertList(companyPhotoDOs);
  }


}
