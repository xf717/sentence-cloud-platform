package com.db.chaomaxs.companyservice.rpc.company.facade.api;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyFullNameRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoCreateReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoDetailRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoListReqDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoListRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoRespDTO;
import com.db.chaomaxs.companyservice.rpc.company.dto.CompanyInfoUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 企业_基础信息
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
public interface CompanyInfoApi {

  /**
   * 添加数据
   *
   * @param createReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/companyInfo/save")
  Long save(@RequestBody CompanyInfoCreateReqDTO createReqDTO);

  /**
   * 更新数据
   *
   * @param updateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/companyInfo/update")
  BaseResponse update(@RequestBody CompanyInfoUpdateReqDTO updateReqDTO);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/companyInfo/get/{id}")
  ObjectRestResponse<CompanyInfoRespDTO> getCompanyInfoById(@PathVariable("id") Long id);

  /**
   * 根据ID获取公司详情，包括产品图片、营业信息等
   * @param id
   * @return
   */
  @GetMapping("/facade/companyInfo/get/{id}/detail")
  ObjectRestResponse<CompanyInfoDetailRespDTO> getCompanyInfoDetailById(@PathVariable("id") Long id);

  /**
   * 根据公司Ids查找
   *
   * @param companyInfoListReqDTO
   * @return
   */
  @PostMapping("/facade/companyInfo/list/ids")
  ObjectRestResponse<List<CompanyInfoListRespDTO>> listCompanyInfoByIds(
      @RequestBody CompanyInfoListReqDTO companyInfoListReqDTO);

  /**
   * 根据公司全称查找
   *
   * @param companyName companyName
   * @return
   */
  @GetMapping("/facade/companyInfo/getByCompanyName")
  ObjectRestResponse<CompanyInfoRespDTO> getCompanyInfoByCompanyName(
      @RequestParam("companyName") String companyName);

  /**
   * 根据公司名称模糊查找
   *
   * @param companyName
   * @return
   */
  @GetMapping("/facade/companyInfo/list")
  ObjectRestResponse<List<CompanyFullNameRespDTO>> listCompanyName(
      @RequestParam("companyName") String companyName);


}
