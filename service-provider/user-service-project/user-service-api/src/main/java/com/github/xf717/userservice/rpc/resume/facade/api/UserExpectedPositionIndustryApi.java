package com.github.xf717.userservice.rpc.resume.facade.api;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryPageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryUpdateReqDTO;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户_期望_职位_行业
 *
 * @author wst
 * @date 2021-04-12 13:47:08
 */
public interface UserExpectedPositionIndustryApi {

  /**
   * 添加数据
   *
   * @param createReqDTO 添加参数
   * @return
   */
  @PostMapping("/facade/userExpectedPositionIndustry/save")
  BaseResponse save(@RequestBody UserExpectedPositionIndustryCreateReqDTO createReqDTO);

  /**
   * 更新数据
   *
   * @param updateReqDTO 更新参数
   * @return
   */
  @PutMapping("/facade/userExpectedPositionIndustry/update")
  BaseResponse update(@RequestBody UserExpectedPositionIndustryUpdateReqDTO updateReqDTO);

  /**
   * 根据ID删除数据
   *
   * @param id id
   * @return
   */
  @DeleteMapping("/facade/userExpectedPositionIndustry/remove/{id}")
  BaseResponse remove(@PathVariable("id") Long id);

  /**
   * 根据Id查找
   *
   * @param id id
   * @return
   */
  @GetMapping("/facade/userExpectedPositionIndustry/get/{id}")
  ObjectRestResponse<UserExpectedPositionIndustryRespDTO> getUserExpectedPositionIndustryById(
      @PathVariable("id") Long id);


  /**
   * 根据条件查找数据
   *
   * @param listQuery 查询参数
   * @return
   */
  @PostMapping("/facade/userExpectedPositionIndustry/list")
  ObjectRestResponse<List<UserExpectedPositionIndustryRespDTO>> listUserExpectedPositionIndustrys(
      @RequestBody UserExpectedPositionIndustryListQueryReqDTO listQuery);

  /**
   * 查找数据显示分页
   *
   * @param pageReqDTO 分页参数
   * @return
   */
  @PostMapping("/facade/userExpectedPositionIndustry/page")
  TableResultResponse<UserExpectedPositionIndustryRespDTO> page(
      @RequestBody UserExpectedPositionIndustryPageReqDTO pageReqDTO);

}
