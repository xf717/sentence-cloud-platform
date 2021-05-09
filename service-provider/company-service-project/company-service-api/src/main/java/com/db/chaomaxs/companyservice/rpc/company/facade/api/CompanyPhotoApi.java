package com.db.chaomaxs.companyservice.rpc.company.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyPhotoSaveReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 公司_相册
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
public interface CompanyPhotoApi {

  /**
   * 添加数据
   * @param companyPhotoSaveReqDTO
   * @return
   */
  @PostMapping("/facade/companyPhoto/save-batch")
  BaseResponse saveBatch(@RequestBody CompanyPhotoSaveReqDTO companyPhotoSaveReqDTO);

  /**
   * 获取公司相册
   *
   * @param companyId companyId
   * @return
   */
  @GetMapping("/facade/companyPhoto/get-by-companyId")
  ObjectRestResponse<List<CompanyPhotoRespDTO>> getByCompanyId(@RequestParam("companyId") Long companyId);

}
