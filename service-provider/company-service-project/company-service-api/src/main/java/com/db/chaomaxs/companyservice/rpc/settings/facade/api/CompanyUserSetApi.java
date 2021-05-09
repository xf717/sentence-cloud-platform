package com.db.chaomaxs.companyservice.rpc.settings.facade.api;
import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetQueryReqDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetRespDTO;
import com.db.chaomaxs.companyservice.rpc.settings.dto.CompanyUserSetUpdateReqDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 企业我的设置
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
public interface CompanyUserSetApi {

  /**
   * 添加数据
   *
   * @param createReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/companyUserSet/save")
  BaseResponse save(@RequestBody CompanyUserSetCreateReqDTO createReqDTO);
  /**
   * 更新数据
   *
   * @param updateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/companyUserSet/update")
  BaseResponse update(@RequestBody CompanyUserSetUpdateReqDTO updateReqDTO);
  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/companyUserSet/get/{id}")
  ObjectRestResponse<CompanyUserSetRespDTO> getCompanyUserSetById(@PathVariable("id") Long id);
  /**
   * 根据Id查找
   *
   * @param
   * @return
   */
  @PostMapping("/facade/companyUserSet/get")
  ObjectRestResponse<CompanyUserSetRespDTO> getUserSetByCompanyUserIdAndUserId(@RequestBody CompanyUserSetQueryReqDTO companyUserSetQueryReqDTO);

}
