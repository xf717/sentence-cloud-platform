package com.db.chaomaxs.companyservice.rpc.company;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.common.framework.vo.PageResult;
import com.db.chaomaxs.companyservice.manager.company.CompanyUserWordManager;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordListQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyUserWordUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.CompanyUserWordRpcFacade;
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
public class CompanyUserWordRpcImpl implements CompanyUserWordRpcFacade {

  @Autowired
  private CompanyUserWordManager companyUserWordManager;

  @Override
  public BaseResponse save(CompanyUserWordCreateReqDTO companyUserWordCreateReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    companyUserWordManager.saveCompanyUserWord(companyUserWordCreateReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(CompanyUserWordUpdateReqDTO companyUserWordUpdateReqDTO) {
    return null;
  }

  @Override
  public BaseResponse remove(Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<CompanyUserWordRespDTO> getCompanyUserWordById(Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<List<CompanyUserWordRespDTO>> listCompanyUserWords(
      CompanyUserWordListQueryReqDTO listQuery) {
    return null;
  }

  @Override
  public TableResultResponse<CompanyUserWordRespDTO> page(CompanyUserWordPageReqDTO pageReqDTO) {
    PageResult<CompanyUserWordRespDTO> pageResult = companyUserWordManager
        .pageCompanyUserWord(pageReqDTO);
    TableResultResponse<CompanyUserWordRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

}
