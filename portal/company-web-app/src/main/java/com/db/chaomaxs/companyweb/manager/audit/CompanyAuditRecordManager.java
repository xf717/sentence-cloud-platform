package com.db.chaomaxs.companyweb.manager.audit;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.audit.dto.CompanyAuditRecordRespDTO;
import com.db.chaomaxs.companyservice.rpc.audit.facade.CompanyAuditRecordRpcFacade;
import com.db.chaomaxs.companyweb.controller.audit.dto.CompanyAuditRecordAddDTO;
import com.db.chaomaxs.companyweb.controller.audit.dto.CompanyAuditRecordDTO;
import com.db.chaomaxs.companyweb.controller.audit.dto.CompanyAuditRecordPageDTO;
import com.db.chaomaxs.companyweb.controller.audit.dto.CompanyAuditRecordUpdateDTO;
import com.db.chaomaxs.companyweb.controller.audit.vo.CompanyAuditRecordVO;
import com.db.chaomaxs.companyweb.convert.audit.CompanyAuditRecordConvert;
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
  private CompanyAuditRecordRpcFacade companyAuditRecordRpcFacade;

  /**
   * 添加数据
   *
   * @param addDTO 添加参数
   * @return
   */
  public int save(CompanyAuditRecordAddDTO addDTO) {
    // TODO 自己实业务 只是个简单的例子
    BaseResponse baseResponse = companyAuditRecordRpcFacade
        .save(CompanyAuditRecordConvert.INSTANCE.convert(addDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 更新数据
   *
   * @param updateDTO 更新参数
   * @return
   */
  public int update(CompanyAuditRecordUpdateDTO updateDTO) {
    BaseResponse baseResponse = companyAuditRecordRpcFacade
        .update(CompanyAuditRecordConvert.INSTANCE.convert(updateDTO));
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  public int remove(Long id) {
    BaseResponse baseResponse = companyAuditRecordRpcFacade.remove(id);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  public CompanyAuditRecordVO getCompanyAuditRecordById(Long id) {
    ObjectRestResponse<CompanyAuditRecordRespDTO> objectRestResponse = companyAuditRecordRpcFacade
        .getCompanyAuditRecordById(id);
    objectRestResponse.checkError();
    return CompanyAuditRecordConvert.INSTANCE.convert(objectRestResponse.getData());
  }


  /**
   * 根据条件查找数据
   *
   * @param companyAuditRecordDTO 查询参数
   * @return
   */
  public List<CompanyAuditRecordVO> listCompanyAuditRecords(
      CompanyAuditRecordDTO companyAuditRecordDTO) {
    ObjectRestResponse<List<CompanyAuditRecordRespDTO>> objectRestResponse = companyAuditRecordRpcFacade
        .listCompanyAuditRecords(CompanyAuditRecordConvert.INSTANCE.convert(companyAuditRecordDTO));
    objectRestResponse.checkError();
    return CompanyAuditRecordConvert.INSTANCE.convertList(objectRestResponse.getData());
  }

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  public TableResultResponse<CompanyAuditRecordVO> pageCompanyAuditRecord(
      CompanyAuditRecordPageDTO pageReqDTO) {
    TableResultResponse<CompanyAuditRecordRespDTO> tableResultResponse = companyAuditRecordRpcFacade
        .page(CompanyAuditRecordConvert.INSTANCE.convert(pageReqDTO));
    tableResultResponse.checkError();
    return CompanyAuditRecordConvert.INSTANCE.convert(tableResultResponse);
  }


}
