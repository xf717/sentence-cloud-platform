package com.db.chaomaxs.companyservice.rpc.audit;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.manager.audit.CompanyAuditRecordManager;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordRespDTO;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.audit.facade.CompanyAuditRecordRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RPC 服务实现类
 *
 * @author xiaofeng
 * @data 2021-03-26 10:18:33
 */
@Slf4j
@Service
public class CompanyAuditRecordRpcImpl implements CompanyAuditRecordRpcFacade {

  @Autowired
  private CompanyAuditRecordManager companyAuditRecordManager;

  @Override
  public BaseResponse save(CompanyAuditRecordCreateReqDTO companyAuditRecordCreateReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    companyAuditRecordManager.saveCompanyAuditRecord(companyAuditRecordCreateReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(CompanyAuditRecordUpdateReqDTO companyAuditRecordUpdateReqDTO) {
    return null;
  }

  @Override
  public BaseResponse remove(Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<CompanyAuditRecordRespDTO> getCompanyAuditRecordById(Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<List<CompanyAuditRecordRespDTO>> listCompanyAuditRecords(
      CompanyAuditRecordListQueryReqDTO listQuery) {
    return null;
  }

  @Override
  public TableResultResponse<CompanyAuditRecordRespDTO> page(
      CompanyAuditRecordPageReqDTO pageReqDTO) {
    PageResult<CompanyAuditRecordRespDTO> pageResult = companyAuditRecordManager
        .pageCompanyAuditRecord(pageReqDTO);
    TableResultResponse<CompanyAuditRecordRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

}
