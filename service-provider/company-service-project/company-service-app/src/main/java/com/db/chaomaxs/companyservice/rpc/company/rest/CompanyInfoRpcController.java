package com.db.chaomaxs.companyservice.rpc.company.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.company.CompanyInfoRpcImpl;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyFullNameRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoDetailRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoListReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoListRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.api.CompanyInfoApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业_基础信息
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@RestController
public class CompanyInfoRpcController implements CompanyInfoApi {

  @Autowired
  private CompanyInfoRpcImpl companyInfoRpc;

  @Override
  public Long save(@RequestBody CompanyInfoCreateReqDTO companyInfoCreateReqDTO) {
    return companyInfoRpc.save(companyInfoCreateReqDTO);
  }

  @Override
  public BaseResponse update(@RequestBody CompanyInfoUpdateReqDTO companyInfoUpdateReqDTO) {
    companyInfoRpc.update(companyInfoUpdateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public ObjectRestResponse<CompanyInfoRespDTO> getCompanyInfoById(@PathVariable("id") Long id) {
    return companyInfoRpc.getCompanyInfoById(id);
  }

  @Override
  public ObjectRestResponse<CompanyInfoDetailRespDTO> getCompanyInfoDetailById(Long id) {
    return companyInfoRpc.getCompanyInfoDetailById(id);
  }

  @Override
  public ObjectRestResponse<List<CompanyInfoListRespDTO>> listCompanyInfoByIds(
      @RequestBody CompanyInfoListReqDTO companyInfoListReqDTO) {
    return companyInfoRpc.listCompanyInfoByIds(companyInfoListReqDTO);
  }

  @Override
  public ObjectRestResponse<CompanyInfoRespDTO> getCompanyInfoByCompanyName(
      @RequestParam("companyName") String companyName) {
    return companyInfoRpc.getCompanyInfoByCompanyName(companyName);
  }

  @Override
  public  ObjectRestResponse<List<CompanyFullNameRespDTO>> listCompanyName(
      @RequestParam("companyName") String companyName){
    return companyInfoRpc.listCompanyName(companyName);
  }
}
