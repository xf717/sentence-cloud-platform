package com.db.chaomaxs.systemservice.rpc.auth.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.auth.BaseGroupLeaderRpcImpl;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupLeaderUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.facade.api.BaseGroupLeaderApi;
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
