package com.db.chaomaxs.companyservice.rpc.collect.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectRespDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.CompanyUserCollectPageReqDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.UserCollectRespDTO;
import com.db.chaomaxs.companyservice.rpc.collect.dto.UserCollectPageReqDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 企业_用户_收藏
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
public interface CompanyUserCollectApi {

  /**
   * 保存企业用户收藏数
   *
   */
  @PostMapping("/facade/companyUserCollect/save")
  BaseResponse save(@RequestBody CompanyUserCollectCreateReqDTO createReqDTO);

  /**
   * 移除企业用户收藏数
   *
   */
  @DeleteMapping("/facade/companyUserCollect/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/companyUserCollect/get/{id}")
  ObjectRestResponse<CompanyUserCollectRespDTO> getCompanyUserCollectById(@PathVariable("id") Long id);


  /**
   * 企业用户我的收藏
   *
   */
  @PostMapping("/facade/companyUserCollect/page")
  TableResultResponse<CompanyUserCollectRespDTO> page(@RequestBody CompanyUserCollectPageReqDTO pageReqDTO);

  /**
   * 对用户感兴趣列表
   *
   */
  @PostMapping("/facade/userCollect/page")
  TableResultResponse<UserCollectRespDTO> userPage(@RequestBody UserCollectPageReqDTO pageReqDTO);
}
