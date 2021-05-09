package com.github.xf717.systemservice.rpc.auth.rest;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.systemservice.rpc.auth.BaseMenuRpcImpl;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseMenuUpdateReqDTO;
import com.github.xf717.systemservice.rpc.auth.facade.api.BaseMenuApi;
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
public class BaseMenuRpcController implements BaseMenuApi {

  @Autowired
  private BaseMenuRpcImpl baseMenuRpc;

  @Override
  public BaseResponse save(@RequestBody BaseMenuCreateReqDTO baseMenuCreateReqDTO) {
    return baseMenuRpc.save(baseMenuCreateReqDTO);
  }

  @Override
  public BaseResponse update(@RequestBody BaseMenuUpdateReqDTO baseMenuUpdateReqDTO) {
    return baseMenuRpc.update(baseMenuUpdateReqDTO);
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return baseMenuRpc.remove(id);
  }

  @Override
  public ObjectRestResponse<BaseMenuRespDTO> getBaseMenuById(@PathVariable("id") Long id) {
    return baseMenuRpc.getBaseMenuById(id);
  }

  @Override
  public ObjectRestResponse<List<BaseMenuRespDTO>> listBaseMenus(
      @RequestBody BaseMenuListQueryReqDTO listQuery) {
    return baseMenuRpc.listBaseMenus(listQuery);
  }

  @Override
  public TableResultResponse<BaseMenuRespDTO> page(@RequestBody BaseMenuPageReqDTO page) {
    return baseMenuRpc.page(page);
  }

  @Override
  public ObjectRestResponse<List<BaseMenuRespDTO>> listAllMenus() {
    return baseMenuRpc.listAllMenus();
  }

  @Override
  public ObjectRestResponse<List<BaseMenuRespDTO>> listMenus(String path, Long id) {
    return baseMenuRpc.listMenus(path, id);
  }

  @Override
  public ObjectRestResponse<List<BaseMenuRespDTO>> listUserAuthorityMenus(Long userId) {
    return baseMenuRpc.listUserAuthorityMenus(userId);
  }

  @Override
  public ObjectRestResponse<List<BaseMenuRespDTO>> listUserAuthoritySystems(Long userId) {
    return baseMenuRpc.listUserAuthoritySystems(userId);
  }
}
