package com.db.chaomaxs.systemservice.rpc.auth.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * @author xiaofeng
 * @date 2017/8/22
 */
@Data
public class FrontUserV2RespDTO {

  /**
   * 头像地址
   */
  public String avatarUrl;
  /**
   * 昵称
   */
  public String userName;
  /**
   * 角色列表
   */
  public List<String> userRoles;
  /**
   * 用户动作权限编码
   */
  private List<String> userPermissions = new ArrayList<>();
  /**
   * 可访问菜单
   */
  private List<AccessMenuTreeRespDTO> accessMenus = new ArrayList<>();

  private List<AccessMenuTreeRespDTO> accessHeader = new ArrayList<>();
  /**
   * 可访问路由
   */
  private List<AccessRouteTreeRespDTO> accessRoutes = new ArrayList<>();

  /**
   * 可访问接口
   */
  private List<AccessInterfaceRespDTO> accessInterfaces = new ArrayList<>();

  private String isAdmin = "0";

}
