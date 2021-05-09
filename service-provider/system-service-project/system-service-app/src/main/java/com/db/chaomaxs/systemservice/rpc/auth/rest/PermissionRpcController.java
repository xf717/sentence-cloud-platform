package com.db.chaomaxs.systemservice.rpc.auth.rest;

import com.db.chaomaxs.common.framework.msg.ObjectRestResponse;
import com.db.chaomaxs.common.framework.vo.authority.CheckPermissionInfo;
import com.db.chaomaxs.common.framework.vo.authority.PermissionInfo;
import com.db.chaomaxs.common.framework.vo.user.UserInfo;
import com.db.chaomaxs.systemservice.rpc.auth.PermissionRpcImpl;
import com.db.chaomaxs.systemservice.rpc.auth.facade.api.PermissionApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * PermissionRpcController
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/30 19:55
 */
@RestController
public class PermissionRpcController implements PermissionApi {

  @Autowired
  private PermissionRpcImpl permissionRpc;

  @Override
  public ObjectRestResponse<UserInfo> validate(String username, String password) {
    return permissionRpc.validate(username, password);
  }

  @Override
  public ObjectRestResponse<List<PermissionInfo>> getAllPermission() {
    return permissionRpc.getAllPermission();
  }

  @Override
  public ObjectRestResponse<List<PermissionInfo>> getPermissionByUsername(String username) {
    return permissionRpc.getPermissionByUsername(username);
  }

  /**
   * <p>
   * 检查用户权限，在网关中直接通过WebClient.Builder webClientBuilder 调用uri : http://system-service/facade/user/{username}/check_permission?requestMethod="
   * + method + "&requestUri=" + requestUri, user.getUniqueName()
   * </p>
   *
   * @param username
   * @param requestUri
   * @param requestMethod
   * @return
   */
  @RequestMapping(value = "/facade/user/{username}/check_permission", method = RequestMethod.GET)
  public Mono<CheckPermissionInfo> checkUserPermission(@PathVariable("username") String username,
      String requestUri, String requestMethod) {
    return permissionRpc.checkUserPermission(username, requestUri, requestMethod);
  }

}
