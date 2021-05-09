package com.db.chaomaxs.companyservice.rpc.company.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyProductRespDTO;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 公司_产品
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
public interface CompanyProductApi {

  /**
   * 添加数据
   *
   * @param companyProductCreateReqDTOs 添加参数
   * @return
   */
  @PostMapping("/facade/companyProduct/save")
  BaseResponse save(@RequestBody List<CompanyProductCreateReqDTO> companyProductCreateReqDTOs);

  /**
   * 获取产品信息
   *
   * @param id 查询参数
   * @return
   */
  @PostMapping("/facade/companyProduct/get/{id}")
  ObjectRestResponse<CompanyProductRespDTO> getCompanyProductById(@PathVariable("id") Long id);

  /**
   * 获取公司所有产品信息
   *
   * @param companyId 查询参数
   * @return
   */
  @PostMapping("/facade/companyProduct/get-by-companyId")
  ObjectRestResponse<List<CompanyProductRespDTO>> listProducts(@RequestParam("companyId") Long companyId);

}
