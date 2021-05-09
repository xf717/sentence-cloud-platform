package com.db.chaomaxs.systemservice.rpc.auth.rest;

import com.db.chaomaxs.common.framework.msg.BaseResponse;
import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.msg.TableResultResponse;
import com.db.chaomaxs.systemservice.rpc.auth.BaseUserRpcImpl;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserCreateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserListQueryReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserPageReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.BaseUserUpdateReqDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.FrontUserRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.FrontUserV2RespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.MenuTreeRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.facade.api.BaseUserApi;
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
public class BaseUserRpcController implements BaseUserApi {

  @Autowired
  private BaseUserRpcImpl baseUserRpc;

  @Override
  public BaseResponse save(@RequestBody BaseUserCreateReqDTO baseUserCreateReqDTO) {
    return baseUserRpc.save(baseUserCreateReqDTO);

  }

  @Override
  public BaseResponse update(@RequestBody BaseUserUpdateReqDTO baseUserUpdateReqDTO) {
    return baseUserRpc.update(baseUserUpdateReqDTO);
  }

  @Override
  public BaseResponse remove(@PathVariable("id") Long id) {
    return baseUserRpc.remove(id);
  }

  @Override
  public ObjectRestResponse<BaseUserRespDTO> getBaseUserById(@PathVariable("id") Long id) {
    return baseUserRpc.getBaseUserById(id);
  }

  @Override
  public ObjectRestResponse<List<BaseUserRespDTO>> listBaseUsers(
      @RequestBody BaseUserListQueryReqDTO listQuery) {
    return baseUserRpc.listBaseUsers(listQuery);
  }

  @Override
  public TableResultResponse<BaseUserRespDTO> page(@RequestBody BaseUserPageReqDTO page) {
    return baseUserRpc.page(page);
  }

  @Override
  public ObjectRestResponse<BaseUserRespDTO> getUserByUsername(
      @PathVariable("username") String username) {
    return baseUserRpc.getUserByUsername(username);
  }

  @Override
  public ObjectRestResponse<FrontUserRespDTO> getUserInfo(String token) {
    return baseUserRpc.getUserInfo(token);
  }

  @Override
  public ObjectRestResponse<FrontUserV2RespDTO> getUserInfoV2() {
    return baseUserRpc.getUserInfoV2();
  }

  @Override
  public ObjectRestResponse<List<MenuTreeRespDTO>> getMenusByUsername(String token) {
    return baseUserRpc.getMenusByUsername(token);
  }

}
