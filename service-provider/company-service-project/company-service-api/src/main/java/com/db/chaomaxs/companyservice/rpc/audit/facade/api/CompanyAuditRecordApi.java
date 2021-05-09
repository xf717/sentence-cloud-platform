package com.db.chaomaxs.companyservice.rpc.audit.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordRespDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 公司_审核记录信息表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
public interface CompanyAuditRecordApi {

  /**
   * 添加数据
   *
   * @param companyAuditRecordCreateReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/companyAuditRecord/save")
  BaseResponse save(@RequestBody CompanyAuditRecordCreateReqDTO companyAuditRecordCreateReqDTO);

  /**
   * 更新数据
   *
   * @param companyAuditRecordUpdateDTO 更新参数
   * @return
   */
  @PutMapping("/facade/companyAuditRecord/update")
  BaseResponse update(@RequestBody CompanyAuditRecordUpdateReqDTO companyAuditRecordUpdateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/companyAuditRecord/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/companyAuditRecord/get/{id}")
  ObjectRestResponse<CompanyAuditRecordRespDTO> getCompanyAuditRecordById(
      @PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/companyAuditRecord/list")
  ObjectRestResponse<List<CompanyAuditRecordRespDTO>> listCompanyAuditRecords(
      @RequestBody CompanyAuditRecordListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/companyAuditRecord/page")
  TableResultResponse<CompanyAuditRecordRespDTO> page(
      @RequestBody CompanyAuditRecordPageReqDTO pageReqDTO);

}
