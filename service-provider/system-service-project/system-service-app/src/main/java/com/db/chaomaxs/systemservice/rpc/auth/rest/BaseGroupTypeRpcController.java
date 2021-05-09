package com.db.chaomaxs.systemservice.rpc.auth.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.auth.BaseGroupTypeRpcImpl;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypeCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypeListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypePageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypeRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseGroupTypeUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.facade.api.BaseGroupTypeApi;
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
public class BaseGroupTypeRpcController implements BaseGroupTypeApi {

  @Autowired
  private BaseGroupTypeRpcImpl baseGroupTypeRpc;

  @Override
  public BaseResponse save(@RequestBody BaseGroupTypeCreateReqDTO baseGroupTypeCreateReqDTO) {
    return baseGroupTypeRpc.save(baseGroupTypeCreateReqDTO);
  }

  @Override
  public BaseResponse update(@RequestBody BaseGroupTypeUpdateReqDTO baseGroupTypeUpdateReqDTO) {
    return baseGroupTypeRpc.update(baseGroupTypeUpdateReqDTO);
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return baseGroupTypeRpc.remove(id);
  }

  @Override
  public ObjectRestResponse<BaseGroupTypeRespDTO> getBaseGroupTypeById(
      @PathVariable("id") Long id) {
    return baseGroupTypeRpc.getBaseGroupTypeById(id);
  }

  @Override
  public ObjectRestResponse<List<BaseGroupTypeRespDTO>> listBaseGroupTypes(
      @RequestBody BaseGroupTypeListQueryReqDTO listQuery) {
    return baseGroupTypeRpc.listBaseGroupTypes(listQuery);
  }

  @Override
  public TableResultResponse<BaseGroupTypeRespDTO> page(@RequestBody BaseGroupTypePageReqDTO page) {
    return baseGroupTypeRpc.page(page);
  }
}
