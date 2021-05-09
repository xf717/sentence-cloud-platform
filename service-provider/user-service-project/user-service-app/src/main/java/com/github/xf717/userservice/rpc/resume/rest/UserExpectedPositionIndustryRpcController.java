package com.github.xf717.userservice.rpc.resume.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.userservice.rpc.resume.UserExpectedPositionIndustryRpcImpl;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryCreateReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryListQueryReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryPageReqDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryRespDTO;
import com.github.xf717.userservice.rpc.resume.dto.UserExpectedPositionIndustryUpdateReqDTO;
import com.github.xf717.userservice.rpc.resume.facade.api.UserExpectedPositionIndustryApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户_期望_职位_行业
 *
 * @author wst
 * @date 2021-04-12 13:47:08
 */
@RestController
public class UserExpectedPositionIndustryRpcController implements UserExpectedPositionIndustryApi {

  @Autowired
  private UserExpectedPositionIndustryRpcImpl userExpectedPositionIndustryRpc;

  @Override
  public BaseResponse save(@RequestBody UserExpectedPositionIndustryCreateReqDTO createReqDTO) {
    return userExpectedPositionIndustryRpc.save(createReqDTO);
  }

  @Override
  public BaseResponse update(@RequestBody UserExpectedPositionIndustryUpdateReqDTO updateReqDTO) {
    return userExpectedPositionIndustryRpc.update(updateReqDTO);
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return userExpectedPositionIndustryRpc.remove(id);
  }

  @Override
  public ObjectRestResponse<UserExpectedPositionIndustryRespDTO> getUserExpectedPositionIndustryById(
      @PathVariable("id") Long id) {
    return userExpectedPositionIndustryRpc.getUserExpectedPositionIndustryById(id);
  }

  @Override
  public ObjectRestResponse<List<UserExpectedPositionIndustryRespDTO>> listUserExpectedPositionIndustrys(
      @RequestBody UserExpectedPositionIndustryListQueryReqDTO listQuery) {
    return userExpectedPositionIndustryRpc.listUserExpectedPositionIndustrys(listQuery);
  }

  @Override
  public TableResultResponse<UserExpectedPositionIndustryRespDTO> page(
      @RequestBody UserExpectedPositionIndustryPageReqDTO pageReqDTO) {
    return userExpectedPositionIndustryRpc.page(pageReqDTO);
  }
}
