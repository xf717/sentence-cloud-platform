package com.db.chaomaxs.common.framework.vo.authority;

import lombok.Data;

/**
 * @author xiaofeng
 * @create 2020/7/23.
 */
@Data
public class CheckPermissionInfo {

  /**
   * 请求权限资源
   */

  private PermissionInfo permissionInfo;
  /**
   * 是否有权限
   */

  private Boolean isAuth;
}
