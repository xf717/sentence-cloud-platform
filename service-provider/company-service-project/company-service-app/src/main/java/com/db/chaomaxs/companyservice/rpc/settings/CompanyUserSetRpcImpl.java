package com.db.chaomaxs.companyservice.rpc.settings;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.manager.settings.CompanyUserSetManager;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetRespDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.facade.CompanyUserSetRpcFacade;
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
public class CompanyUserSetRpcImpl implements CompanyUserSetRpcFacade {

  @Autowired
  private CompanyUserSetManager companyUserSetManager;

  @Override
  public BaseResponse save(CompanyUserSetCreateReqDTO companyUserSetCreateReqDTO) {
    companyUserSetManager.saveCompanyUserSet(companyUserSetCreateReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(CompanyUserSetUpdateReqDTO companyUserSetUpdateReqDTO) {
    companyUserSetManager.updateCompanyUserSet(companyUserSetUpdateReqDTO);
    return BaseResponse.success("修改成功");
  }

  @Override
  public ObjectRestResponse<CompanyUserSetRespDTO> getCompanyUserSetById(Long id) {
    CompanyUserSetRespDTO companyUserSetRespDTO = companyUserSetManager.getCompanyUserSetById(id);
    return new ObjectRestResponse<>().data(companyUserSetRespDTO);
  }

  @Override
  public ObjectRestResponse<CompanyUserSetRespDTO> getUserSetByCompanyUserIdAndUserId(CompanyUserSetQueryReqDTO companyUserSetQueryReqDTO) {
    CompanyUserSetRespDTO companyUserSetRespDTO = companyUserSetManager.getUserSetByCompanyUserIdAndUserId(companyUserSetQueryReqDTO);
    return new ObjectRestResponse<>().data(companyUserSetRespDTO);
  }

}
