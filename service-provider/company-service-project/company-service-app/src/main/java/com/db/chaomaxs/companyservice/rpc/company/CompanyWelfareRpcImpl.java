package com.db.chaomaxs.companyservice.rpc.company;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.manager.company.CompanyWelfareManager;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareSaveReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.CompanyWelfareRpcFacade;
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
public class CompanyWelfareRpcImpl implements CompanyWelfareRpcFacade {

  @Autowired
  private CompanyWelfareManager companyWelfareManager;

  @Override
  public BaseResponse customTypeSave(CompanyWelfareCreateReqDTO companyWelfareCreateReqDTO) {
    companyWelfareManager.saveCompanyWelfare(companyWelfareCreateReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(CompanyWelfareUpdateReqDTO companyWelfareUpdateReqDTO) {
    companyWelfareManager.updateCompanyWelfare(companyWelfareUpdateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    companyWelfareManager.deleteCompanyWelfare(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<CompanyWelfareRespDTO> getCompanyWelfareById(Long id) {
    return ObjectRestResponse.success(companyWelfareManager.getCompanyWelfareById(id));
  }

  @Override
  public ObjectRestResponse<List<CompanyWelfareRespDTO>> listWelfareTypes(Long comapnyId) {
    List<CompanyWelfareRespDTO> chooseWelfares = companyWelfareManager.listWelfareTypes(comapnyId);
    return ObjectRestResponse.success(chooseWelfares);
  }

  @Override
  public BaseResponse saveChooseWelfare(List<CompanyWelfareSaveReqDTO> companyWelfareSaveReqDTOs) {
    companyWelfareManager.saveChooseWelfare(companyWelfareSaveReqDTOs);
    return BaseResponse.success("保存成功！");
  }

  @Override
  public ObjectRestResponse<List<CompanyWelfareRespDTO>> listAllWelfare(Long companyId) {
    return ObjectRestResponse.success(companyWelfareManager.listAllWelfare(companyId));
  }

}
