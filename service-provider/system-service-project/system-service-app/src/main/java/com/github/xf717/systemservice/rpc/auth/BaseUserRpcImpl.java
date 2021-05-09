package com.github.xf717.systemservice.rpc.auth;

import com.github.xf717.common.framework.msg.BaseResponse;
import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.msg.TableResultResponse;
import com.github.xf717.common.framework.vo.PageResult;
import com.github.xf717.systemservice.manager.auth.BaseUserManager;
import com.github.xf717.systemservice.manager.auth.PermissionManager;
import com.github.xf717.systemservice.rpc.auth.dto.BaseUserCreateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseUserListQueryReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseUserPageReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseUserRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.BaseUserUpdateReqDTO;
import com.github.xf717.systemservice.rpc.auth.dto.FrontUserRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.FrontUserV2RespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.MenuTreeRespDTO;
import com.github.xf717.systemservice.rpc.auth.facade.BaseUserRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BaseUserRpcImpl implements BaseUserRpcFacade {

  @Autowired
  private BaseUserManager baseUserManager;

  @Autowired
  private PermissionManager permissionManager;


  @Override
  public BaseResponse save(BaseUserCreateReqDTO baseUserCreateReqDTO) {
    // 如果需要返回值,请更改 BaseResponse 为ObjectResponse
    baseUserManager.saveBaseUser(baseUserCreateReqDTO);
    return BaseResponse.success("保存成功");
  }

  @Override
  public BaseResponse update(BaseUserUpdateReqDTO baseUserUpdateReqDTO) {
    baseUserManager.updateBaseUser(baseUserUpdateReqDTO);
    return BaseResponse.success("修改成功");
  }

  @Override
  public BaseResponse remove(Long id) {
    baseUserManager.deleteBaseUser(id);
    return BaseResponse.success("删除成功");
  }

  @Override
  public ObjectRestResponse<BaseUserRespDTO> getBaseUserById(Long id) {
    BaseUserRespDTO baseUserRespDTO = baseUserManager.getBaseUserById(id);
    return new ObjectRestResponse<>().data(baseUserRespDTO);
  }

  @Override
  public ObjectRestResponse<List<BaseUserRespDTO>> listBaseUsers(
      BaseUserListQueryReqDTO listQuery) {
    List<BaseUserRespDTO> list = baseUserManager.listBaseUsers(listQuery);
    return new ObjectRestResponse<>().data(list);
  }

  @Override
  public TableResultResponse<BaseUserRespDTO> page(BaseUserPageReqDTO pageReqDTO) {
    PageResult<BaseUserRespDTO> pageResult = baseUserManager.pageBaseUser(pageReqDTO);
    TableResultResponse<BaseUserRespDTO> tableResultResponse = new TableResultResponse(
        pageResult.getTotal(), pageResult.getList());
    return tableResultResponse;
  }

  @Override
  public ObjectRestResponse<BaseUserRespDTO> getUserByUsername(String username) {
    return new ObjectRestResponse<>().data(baseUserManager.getUserByUsername(username));
  }

  @Override
  public ObjectRestResponse<FrontUserRespDTO> getUserInfo(String token) {
    FrontUserRespDTO frontUserRespDTO = permissionManager.getUserInfo(token);
    return new ObjectRestResponse<>().data(frontUserRespDTO);
  }

  @Override
  public ObjectRestResponse<FrontUserV2RespDTO> getUserInfoV2() {
    FrontUserV2RespDTO frontUserV2RespDTO = permissionManager.getUserInfoV2();
    return new ObjectRestResponse<>().data(frontUserV2RespDTO);
  }

  @Override
  public ObjectRestResponse<List<MenuTreeRespDTO>> getMenusByUsername(String token) {
    List<MenuTreeRespDTO> list = permissionManager.getMenusByUsername(token);
    return new ObjectRestResponse<>().data(list);
  }

}
