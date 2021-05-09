package com.db.chaomaxs.companyservice.manager.company;

import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareSaveReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareUpdateReqDTO;
import com.db.chaomaxs.companyservice.service.company.CompanyWelfareService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyWelfareManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyWelfareManager {

  @Autowired
  private CompanyWelfareService companyWelfareService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveCompanyWelfare(CompanyWelfareCreateReqDTO createReqDTO) {
    return companyWelfareService.saveCompanyWelfare(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateCompanyWelfare(CompanyWelfareUpdateReqDTO updateReqDTO) {
    return companyWelfareService.updateCompanyWelfare(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteCompanyWelfare(Long id) {
    return companyWelfareService.deleteCompanyWelfare(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<CompanyWelfareRespDTO> listCompanyWelfares(
      CompanyWelfareListQueryReqDTO listQueryReqDTO) {
    return companyWelfareService.listCompanyWelfares(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public CompanyWelfareRespDTO getCompanyWelfareById(Long id) {
    return companyWelfareService.getCompanyWelfareById(id);
  }
  /**
   * 获取选中福利类型
   *
   * @param companyId companyId
   * @return
   */
  public List<CompanyWelfareRespDTO> listWelfareTypes(Long companyId) {
    return companyWelfareService.listWelfareTypes(companyId);
  }

  /**
   * 保存选中福利类型
   * @param companyWelfareSaveReqDTOs
   */
  public void saveChooseWelfare(List<CompanyWelfareSaveReqDTO> companyWelfareSaveReqDTOs) {
    companyWelfareService.saveChooseWelfare(companyWelfareSaveReqDTOs);
  }

  /**
   * 获取所有福利类型
   * @param companyId
   * @return
   */
  public List<CompanyWelfareRespDTO> listAllWelfare(Long companyId) {
    return companyWelfareService.listAllWelfare(companyId);
  }

}
