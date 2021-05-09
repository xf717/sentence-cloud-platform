package com.github.xf717.systemservice.rpc.auth.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.auth.BaseGroupMemberRpcImpl;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupMemberCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupMemberListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupMemberPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupMemberRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupMemberUpdateReqDTO;
import com.github.xf717.systemservice.rpc.auth.facade.api.BaseGroupMemberApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@RestController
public class BaseGroupMemberRpcController implements BaseGroupMemberApi {

  @Autowired
  private BaseGroupMemberRpcImpl baseGroupMemberRpc;

  @Override
  public BaseResponse save(@RequestBody BaseGroupMemberCreateReqDTO baseGroupMemberCreateReqDTO) {
    return baseGroupMemberRpc.save(baseGroupMemberCreateReqDTO);
  }

  @Override
  public BaseResponse update(@RequestBody BaseGroupMemberUpdateReqDTO baseGroupMemberUpdateReqDTO) {
    return baseGroupMemberRpc.update(baseGroupMemberUpdateReqDTO);
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return baseGroupMemberRpc.remove(id);
  }

  @Override
  public ObjectRestResponse<BaseGroupMemberRespDTO> getBaseGroupMemberById(
      @PathVariable("id") Long id) {
    return baseGroupMemberRpc.getBaseGroupMemberById(id);
  }

  @Override
  public ObjectRestResponse<List<BaseGroupMemberRespDTO>> listBaseGroupMembers(
      @RequestBody BaseGroupMemberListQueryReqDTO listQuery) {
    return baseGroupMemberRpc.listBaseGroupMembers(listQuery);
  }

  @Override
  public TableResultResponse<BaseGroupMemberRespDTO> page(
      @RequestBody BaseGroupMemberPageReqDTO page) {
    return baseGroupMemberRpc.page(page);
  }
}
