package com.db.chaomaxs.companyservice.rpc.company.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareSaveReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyWelfareUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 公司福利
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
public interface CompanyWelfareApi {

  /**
   * 自定义福利类型保存
   *
   * @param createReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/companyWelfare/customTypeSave")
  BaseResponse customTypeSave(@RequestBody CompanyWelfareCreateReqDTO createReqDTO);

  /**
   * 更新数据
   *
   * @param updateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/companyWelfare/update")
  BaseResponse update(@RequestBody CompanyWelfareUpdateReqDTO updateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/companyWelfare/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/companyWelfare/get/{id}")
  ObjectRestResponse<CompanyWelfareRespDTO> getCompanyWelfareById(@PathVariable("id") Long id);

  /**
   * 获取公司选中福利类型
   *
   * @param comapnyId comapnyId
   * @return
   */
  @GetMapping("/facade/companyWelfare/getWelfareType")
  ObjectRestResponse<List<CompanyWelfareRespDTO>> listWelfareTypes(@RequestParam("comapnyId") Long comapnyId);

  /**
   * 保存福利类型
   * @param companyWelfareSaveReqDTOs
   * @return
   */
  @GetMapping("/facade/companyWelfare/saveChooseWelfare")
  BaseResponse saveChooseWelfare(@RequestBody List<CompanyWelfareSaveReqDTO> companyWelfareSaveReqDTOs);

  /**
   * 获取所有福利类型
   * @param companyId
   * @return
   */
  @GetMapping("/facade/companyWelfare/listAllWelfare")
  ObjectRestResponse<List<CompanyWelfareRespDTO>> listAllWelfare(Long companyId);

}
