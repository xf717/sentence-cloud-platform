package com.db.chaomaxs.companyservice.rpc.company.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.company.CompanyPhotoRpcImpl;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoSaveReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.api.CompanyPhotoApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公司_相册
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@RestController
public class CompanyPhotoRpcController implements CompanyPhotoApi {

  @Autowired
  private CompanyPhotoRpcImpl companyPhotoRpc;


  @Override
  public BaseResponse saveBatch(CompanyPhotoSaveReqDTO companyPhotoSaveReqDTO) {
    return companyPhotoRpc.saveBatch(companyPhotoSaveReqDTO);
  }

  @Override
  public ObjectRestResponse<List<CompanyPhotoRespDTO>> getByCompanyId(@RequestParam("companyId") Long companyId) {
    return companyPhotoRpc.getByCompanyId(companyId);
  }
}
