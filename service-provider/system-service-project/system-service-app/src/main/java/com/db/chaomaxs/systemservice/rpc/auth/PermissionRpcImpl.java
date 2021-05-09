package com.db.chaomaxs.systemservice.rpc.auth;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.vo.authority.CheckPermissionInfo;
import com.db.chaomaxs.common.framework.vo.authority.PermissionInfo;
import com.db.chaomaxs.common.framework.vo.user.UserInfo;
import com.db.chaomaxs.systemservice.manager.auth.PermissionManager;
import com.db.chaomaxs.systemservice.rpc.auth.facade.PermissionRpcFacade;
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
