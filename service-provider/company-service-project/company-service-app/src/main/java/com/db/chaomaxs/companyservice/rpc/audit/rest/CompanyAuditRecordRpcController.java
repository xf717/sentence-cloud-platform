package com.db.chaomaxs.companyservice.rpc.audit.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.audit.CompanyAuditRecordRpcImpl;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordRespDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.facade.api.CompanyAuditRecordApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公司_审核记录信息表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@RestController
public class CompanyAuditRecordRpcController implements CompanyAuditRecordApi {

  @Autowired
  private CompanyAuditRecordRpcImpl companyAuditRecordRpc;

  @Override
  public BaseResponse save(
      @RequestBody CompanyAuditRecordCreateReqDTO companyAuditRecordCreateReqDTO) {
    return companyAuditRecordRpc.save(companyAuditRecordCreateReqDTO);
  }

  @Override
  public BaseResponse update(
      @RequestBody CompanyAuditRecordUpdateReqDTO companyAuditRecordUpdateReqDTO) {
    return null;
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<CompanyAuditRecordRespDTO> getCompanyAuditRecordById(
      @PathVariable("id") Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<List<CompanyAuditRecordRespDTO>> listCompanyAuditRecords(
      @RequestBody CompanyAuditRecordListQueryReqDTO listQuery) {
    return null;
  }

  @Override
  public TableResultResponse<CompanyAuditRecordRespDTO> page(
      @RequestBody CompanyAuditRecordPageReqDTO page) {
    return null;
  }
}
