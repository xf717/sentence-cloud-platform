package com.github.xf717.systemservice.rpc.auth.facade.api;

import com.github.xf717.common.framework.msg.ObjectRestResponse;
import com.github.xf717.common.framework.vo.authority.PermissionInfo;
import com.github.xf717.common.framework.vo.user.UserInfo;
import com.github.xf717.systemservice.rpc.auth.dto.FrontUserRespDTO;
import com.github.xf717.systemservice.rpc.auth.dto.FrontUserV2RespDTO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * PermissionApi
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/03/30 19:43
 */
public interface PermissionApi {

  /**
   * 验证用户
   *
   * @param username 用户名
   * @param password 密码
   * @return
   */
  @RequestMapping(value = "/facade/user/validate", method = RequestMethod.POST)
  ObjectRestResponse<UserInfo> validate(@RequestParam("username") String username,
      @RequestParam("password") String password);

  /**
   * 获取全部权限
   *
   * @return
   */
  @GetMapping(value = "/facade/all/permissions")
  ObjectRestResponse<List<PermissionInfo>> getAllPermission();

  /**
   * 查找用户
   *
   * @param username
   * @return
   */
  @GetMapping(value = "/facade/user/{username}/permissions")
  ObjectRestResponse<List<PermissionInfo>> getPermissionByUsername(
      @PathVariable("username") String username);

}
