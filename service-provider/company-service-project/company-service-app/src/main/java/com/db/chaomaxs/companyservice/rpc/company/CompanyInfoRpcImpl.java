package com.db.chaomaxs.companyservice.rpc.company;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.manager.company.CompanyInfoManager;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyFullNameRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoDetailRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoListReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoListRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoUpdateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.CompanyInfoRpcFacade;
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
public class CompanyInfoRpcImpl implements CompanyInfoRpcFacade {

  @Autowired
  private CompanyInfoManager companyInfoManager;

  @Override
  public Long save(CompanyInfoCreateReqDTO companyInfoCreateReqDTO) {
    return companyInfoManager.saveCompanyInfo(companyInfoCreateReqDTO);
  }

  @Override
  public BaseResponse update(CompanyInfoUpdateReqDTO companyInfoUpdateReqDTO) {
    companyInfoManager.updateCompanyInfo(companyInfoUpdateReqDTO);
    return BaseResponse.success("更新成功");
  }

  @Override
  public ObjectRestResponse<CompanyInfoRespDTO> getCompanyInfoById(Long id) {
    return ObjectRestResponse.success(companyInfoManager.getCompanyInfoById(id));
  }

  @Override
  public ObjectRestResponse<CompanyInfoDetailRespDTO> getCompanyInfoDetailById(Long id) {
    return ObjectRestResponse.success(companyInfoManager.getCompanyInfoDetail(id));
  }


  @Override
  public ObjectRestResponse<List<CompanyInfoListRespDTO>> listCompanyInfoByIds(
      CompanyInfoListReqDTO companyInfoListReqDTO) {
    List<CompanyInfoListRespDTO> list = companyInfoManager
        .listCompanyInfoByIds(companyInfoListReqDTO);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public ObjectRestResponse<CompanyInfoRespDTO> getCompanyInfoByCompanyName(String companyName) {
    return new ObjectRestResponse<>()
        .data(companyInfoManager.getCompanyInfoByCompanyName(companyName));
  }

  @Override
  public ObjectRestResponse<List<CompanyFullNameRespDTO>> listCompanyName(String companyName) {
    return new ObjectRestResponse<>().data(companyInfoManager.listCompanyName(companyName));
  }
}
