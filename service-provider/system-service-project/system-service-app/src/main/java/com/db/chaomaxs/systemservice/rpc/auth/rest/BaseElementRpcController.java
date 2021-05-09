package com.db.chaomaxs.systemservice.rpc.auth.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.auth.BaseElementRpcImpl;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseElementCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseElementListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseElementPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseElementRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseElementUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.facade.api.BaseElementApi;
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
public class BaseElementRpcController implements BaseElementApi {

  @Autowired
  private BaseElementRpcImpl baseElementRpc;

  @Override
  public BaseResponse save(@RequestBody BaseElementCreateReqDTO baseElementCreateReqDTO) {
    return baseElementRpc.save(baseElementCreateReqDTO);
  }

  @Override
  public BaseResponse update(@RequestBody BaseElementUpdateReqDTO baseElementUpdateReqDTO) {
    return baseElementRpc.update(baseElementUpdateReqDTO);
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return baseElementRpc.remove(id);
  }

  @Override
  public ObjectRestResponse<BaseElementRespDTO> getBaseElementById(@PathVariable("id") Long id) {
    return baseElementRpc.getBaseElementById(id);
  }

  @Override
  public ObjectRestResponse<List<BaseElementRespDTO>> listBaseElements(
      @RequestBody BaseElementListQueryReqDTO listQuery) {
    return baseElementRpc.listBaseElements(listQuery);
  }

  @Override
  public TableResultResponse<BaseElementRespDTO> page(@RequestBody BaseElementPageReqDTO page) {
    return baseElementRpc.page(page);
  }

  @Override
  public ObjectRestResponse<List<BaseElementRespDTO>> getAuthorityMenuElementByUserId(Long userId,
      Long menuId) {
    return baseElementRpc.getAuthorityMenuElementByUserId(userId, menuId);
  }

  @Override
  public ObjectRestResponse<List<BaseElementRespDTO>> getAuthorityElementByUserId(Long userId) {
    return baseElementRpc.getAuthorityElementByUserId(userId);
  }

  @Override
  public ObjectRestResponse<List<BaseElementRespDTO>> getAllElementPermissions() {
    return baseElementRpc.getAllElementPermissions();
  }
}
