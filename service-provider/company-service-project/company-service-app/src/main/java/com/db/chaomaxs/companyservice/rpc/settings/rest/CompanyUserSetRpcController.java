package com.db.chaomaxs.companyservice.rpc.settings.rest;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.settings.CompanyUserSetRpcImpl;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetRespDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.facade.api.CompanyUserSetApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业我的设置
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@RestController
public class CompanyUserSetRpcController implements CompanyUserSetApi {

  @Autowired
  private CompanyUserSetRpcImpl companyUserSetRpc;

  @Override
  public BaseResponse save(@RequestBody CompanyUserSetCreateReqDTO companyUserSetCreateReqDTO) {
    return companyUserSetRpc.save(companyUserSetCreateReqDTO);
  }

  @Override
  public BaseResponse update(@RequestBody CompanyUserSetUpdateReqDTO companyUserSetUpdateReqDTO) {
    return companyUserSetRpc.update(companyUserSetUpdateReqDTO);
  }

  @Override
  public ObjectRestResponse<CompanyUserSetRespDTO> getCompanyUserSetById(@PathVariable("id") Long id) {
    return companyUserSetRpc.getCompanyUserSetById(id);
  }
  @Override
  public ObjectRestResponse<CompanyUserSetRespDTO> getUserSetByCompanyUserIdAndUserId(CompanyUserSetQueryReqDTO companyUserSetQueryReqDTO) {
    return companyUserSetRpc.getUserSetByCompanyUserIdAndUserId(companyUserSetQueryReqDTO);
  }

}
