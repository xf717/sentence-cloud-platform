package com.db.chaomaxs.companyservice.rpc.company;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.manager.company.CompanyPhotoManager;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoSaveReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.CompanyPhotoRpcFacade;
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
public class CompanyPhotoRpcImpl implements CompanyPhotoRpcFacade {

  @Autowired
  private CompanyPhotoManager companyPhotoManager;

  @Override
  public BaseResponse saveBatch(CompanyPhotoSaveReqDTO companyPhotoSaveReqDTO) {
    companyPhotoManager.saveBatch(companyPhotoSaveReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public ObjectRestResponse<List<CompanyPhotoRespDTO>> getByCompanyId(Long companyId) {
    return ObjectRestResponse.success(companyPhotoManager.getByCompanyId(companyId));
  }

}
