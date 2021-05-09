package com.github.xf717.systemservice.rpc.auth;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.vo.authority.CheckPermissionInfo;
import com.github.xf717.common.framework.vo.authority.PermissionInfo;
import com.github.xf717.common.framework.vo.user.UserInfo;
import com.github.xf717.systemservice.manager.auth.PermissionManager;
import com.github.xf717.systemservice.rpc.auth.facade.PermissionRpcFacade;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * PermissionRpcImpl
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/30 19:56
 */
@Slf4j
@Service
public class PermissionRpcImpl implements PermissionRpcFacade {

  @Autowired
  private PermissionManager permissionManager;

  @Override
  public ObjectRestResponse<UserInfo> validate(String username, String password) {
    UserInfo userInfo = permissionManager.validate(username, password);
    return new ObjectRestResponse<>().data(userInfo);
  }

  @Override
  public ObjectRestResponse<List<PermissionInfo>> getAllPermission() {
    List<PermissionInfo> permissionInfoList = permissionManager.getAllPermission();
    return new ObjectRestResponse<>().data(permissionInfoList);
  }

  @Override
  public ObjectRestResponse<List<PermissionInfo>> getPermissionByUsername(String username) {
    List<PermissionInfo> permissionInfoList = permissionManager.getPermissionByUsername(username);
    return new ObjectRestResponse<>().data(permissionInfoList);
  }

  /**
   * 检查用户权限
   *
   * @param username
   * @param requestUri
   * @param requestMethod
   * @return
   */
  public Mono<CheckPermissionInfo> checkUserPermission(String username, String requestUri,
      String requestMethod) {
    return permissionManager.checkUserPermission(username, requestUri, requestMethod);
  }


}
