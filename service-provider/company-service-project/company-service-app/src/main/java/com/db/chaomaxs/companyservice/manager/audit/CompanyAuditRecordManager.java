package com.db.chaomaxs.companyservice.manager.audit;

import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordRespDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordUpdateReqDTO;
import com.db.chaomaxs.companyservice.service.audit.CompanyAuditRecordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyAuditRecordManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyAuditRecordManager {

  @Autowired
  private CompanyAuditRecordService companyAuditRecordService;

  /**
   * 保存数据
   *
   * @param createReqDTO
   * @return
   */
  public int saveCompanyAuditRecord(CompanyAuditRecordCreateReqDTO createReqDTO) {
    return companyAuditRecordService.saveCompanyAuditRecord(createReqDTO);
  }

  /**
   * 更新数据
   *
   * @param updateReqDTO
   * @return
   */
  public int updateCompanyAuditRecord(CompanyAuditRecordUpdateReqDTO updateReqDTO) {
    return companyAuditRecordService.updateCompanyAuditRecord(updateReqDTO);
  }

  /**
   * 删除数据
   *
   * @param id
   * @return
   */
  public int deleteCompanyAuditRecord(Long id) {
    return companyAuditRecordService.deleteCompanyAuditRecord(id);
  }

  /**
   * 数据查询
   *
   * @param listQueryReqDTO
   * @return
   */
  public List<CompanyAuditRecordRespDTO> listCompanyAuditRecords(
      CompanyAuditRecordListQueryReqDTO listQueryReqDTO) {
    return companyAuditRecordService.listCompanyAuditRecords(listQueryReqDTO);
  }

  /**
   * 根据id获取对象
   *
   * @param id
   * @return
   */
  public CompanyAuditRecordRespDTO getCompanyAuditRecordById(Long id) {
    return companyAuditRecordService.getCompanyAuditRecordById(id);
  }

  /**
   * 分类
   *
   * @param page
   * @return
   */
  public PageResult<CompanyAuditRecordRespDTO> pageCompanyAuditRecord(
      CompanyAuditRecordPageReqDTO page) {
    return companyAuditRecordService.pageCompanyAuditRecord(page);
  }


}
