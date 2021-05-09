package com.db.chaomaxs.companyservice.manager.settings;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetRespDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetUpdateReqDTO;
import com.db.chaomaxs.companyservice.service.settings.CompanyUserSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyUserSetManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@Service
@Validated
public class CompanyUserSetManager {

  @Autowired
  private CompanyUserSetService companyUserSetService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveCompanyUserSet(CompanyUserSetCreateReqDTO createReqDTO) {
    return companyUserSetService.saveCompanyUserSet(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateCompanyUserSet(CompanyUserSetUpdateReqDTO updateReqDTO) {
    return companyUserSetService.updateCompanyUserSet(updateReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public CompanyUserSetRespDTO getCompanyUserSetById(Long id) {
    return companyUserSetService.getCompanyUserSetById(id);
  }



  public CompanyUserSetRespDTO getUserSetByCompanyUserIdAndUserId(CompanyUserSetQueryReqDTO companyUserSetQueryReqDTO) {
    return companyUserSetService.getUserSetByCompanyUserIdAndUserId(companyUserSetQueryReqDTO);
  }
}
