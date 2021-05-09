package com.db.chaomaxs.companyservice.manager.company;

import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoSaveReqDTO;
import com.db.chaomaxs.companyservice.service.company.CompanyPhotoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyPhotoManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyPhotoManager {

  @Autowired
  private CompanyPhotoService companyPhotoService;

  /**
   * 保存数据
   * @param companyPhotoSaveReqDTO
   */
  public void saveBatch(CompanyPhotoSaveReqDTO companyPhotoSaveReqDTO) {
    companyPhotoService.saveBatch(companyPhotoSaveReqDTO);
  }

  /**
   * 获取公司相册
   * @param companyId
   * @return
   */
  public List<CompanyPhotoRespDTO> getByCompanyId(Long companyId) {
    return companyPhotoService.getByCompanyId(companyId);
  }



}
