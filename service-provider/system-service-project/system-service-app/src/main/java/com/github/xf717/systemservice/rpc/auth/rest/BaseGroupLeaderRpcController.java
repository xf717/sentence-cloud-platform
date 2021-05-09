package com.github.xf717.systemservice.rpc.auth.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.auth.BaseGroupLeaderRpcImpl;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupLeaderCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupLeaderListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupLeaderPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupLeaderRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseGroupLeaderUpdateReqDTO;
import com.github.xf717.systemservice.rpc.auth.facade.api.BaseGroupLeaderApi;
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
public class BaseGroupLeaderRpcController implements BaseGroupLeaderApi {

  @Autowired
  private BaseGroupLeaderRpcImpl baseGroupLeaderRpc;

  @Override
  public BaseResponse save(@RequestBody BaseGroupLeaderCreateReqDTO baseGroupLeaderCreateReqDTO) {
    return baseGroupLeaderRpc.save(baseGroupLeaderCreateReqDTO);
  }

  @Override
  public BaseResponse update(@RequestBody BaseGroupLeaderUpdateReqDTO baseGroupLeaderUpdateReqDTO) {
    return baseGroupLeaderRpc.update(baseGroupLeaderUpdateReqDTO);
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return baseGroupLeaderRpc.remove(id);
  }

  @Override
  public ObjectRestResponse<BaseGroupLeaderRespDTO> getBaseGroupLeaderById(
      @PathVariable("id") Long id) {
    return baseGroupLeaderRpc.getBaseGroupLeaderById(id);
  }

  @Override
  public ObjectRestResponse<List<BaseGroupLeaderRespDTO>> listBaseGroupLeaders(
      @RequestBody BaseGroupLeaderListQueryReqDTO listQuery) {
    return baseGroupLeaderRpc.listBaseGroupLeaders(listQuery);
  }

  @Override
  public TableResultResponse<BaseGroupLeaderRespDTO> page(
      @RequestBody BaseGroupLeaderPageReqDTO page) {
    return baseGroupLeaderRpc.page(page);
  }
}
