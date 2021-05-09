package com.db.chaomaxs.companyweb.manager.company;

import com.db.chaomaxs.common.framework.context.BaseContextHandler;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoSaveReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.facade.CompanyPhotoRpcFacade;
import com.db.chaomaxs.companyweb.controller.company.dto.CompanyPhotoAddDTO;
import com.db.chaomaxs.companyweb.controller.company.vo.CompanyPhotoVO;
import com.db.chaomaxs.companyweb.convert.company.CompanyPhotoConvert;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * CompanyPhotoManager
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Service
@Validated
public class CompanyPhotoManager {

  @Autowired
  private CompanyPhotoRpcFacade companyPhotoRpcFacade;

  /**
   * 添加数据
   *
   * @param companyPhotoAddDTOs 添加参数
   * @return
   */
  public int save(List<CompanyPhotoAddDTO> companyPhotoAddDTOs) {
    Long companyId = BaseContextHandler.getCompanyId();
    companyPhotoAddDTOs.stream().forEach(v -> v.setCompanyId(companyId));
    CompanyPhotoSaveReqDTO companyPhotoSaveReqDTO = new CompanyPhotoSaveReqDTO()
        .setCompanyPhotoReqDTOS(CompanyPhotoConvert.INSTANCE.convert(companyPhotoAddDTOs))
        .setCompanyId(companyId);
    BaseResponse baseResponse = companyPhotoRpcFacade
        .saveBatch(companyPhotoSaveReqDTO);
    baseResponse.checkError();
    return baseResponse.isSuccess() ? 1 : 0;
  }

  /**
   * 根据companyId获取公司相册
   *
   * @return
   */
  public List<CompanyPhotoVO> getByCompanyId() {
    ObjectRestResponse<List<CompanyPhotoRespDTO>> objectRestResponse = companyPhotoRpcFacade
        .getByCompanyId(BaseContextHandler.getCompanyId());
    objectRestResponse.checkError();
    return CompanyPhotoConvert.INSTANCE.convertList(objectRestResponse.getData());
  }


}
