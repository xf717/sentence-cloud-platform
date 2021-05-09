package com.db.chaomaxs.companyservice.rpc.company.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.company.CompanyWelfareRpcImpl;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareSaveReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.api.CompanyWelfareApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公司福利
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@RestController
public class CompanyWelfareRpcController implements CompanyWelfareApi {

  @Autowired
  private CompanyWelfareRpcImpl companyWelfareRpc;

  @Override
  public BaseResponse customTypeSave(@RequestBody CompanyWelfareCreateReqDTO companyWelfareCreateReqDTO) {
    companyWelfareRpc.customTypeSave(companyWelfareCreateReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(@RequestBody CompanyWelfareUpdateReqDTO companyWelfareUpdateReqDTO) {
    return null;
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<CompanyWelfareRespDTO> getCompanyWelfareById(
      @PathVariable("id") Long id) {
    return null;
  }

  @Override
  public ObjectRestResponse<List<CompanyWelfareRespDTO>> listWelfareTypes(@RequestParam("comapnyId") Long comapnyId) {
    return companyWelfareRpc.listWelfareTypes(comapnyId);
  }

  @Override
  public BaseResponse saveChooseWelfare(@RequestBody List<CompanyWelfareSaveReqDTO> companyWelfareSaveReqDTOs) {
    return companyWelfareRpc.saveChooseWelfare(companyWelfareSaveReqDTOs);
  }

  @Override
  public ObjectRestResponse<List<CompanyWelfareRespDTO>> listAllWelfare(@RequestParam("comapnyId") Long companyId) {
    return companyWelfareRpc.listAllWelfare(companyId);
  }
}
