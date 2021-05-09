package com.db.chaomaxs.managementweb.controller.auth.vo;

import com.db.chaomaxs.systemservice.rpc.auth.dto.AccessInterfaceRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.AccessMenuTreeRespDTO;
import com.db.chaomaxs.systemservice.rpc.auth.dto.AccessRouteTreeRespDTO;
import io.swagger.annotations.ApiModel;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * FrontUserV2VO
 * TODO 需要在改造一下内部类
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/02 11:39
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "FrontUserV2VO", description = "FrontUserV2VO")
public class FrontUserV2VO {

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
  private List<String> userPermissions;
  /**
   * 可访问菜单
   */
  private List<AccessMenuTreeRespDTO> accessMenus;

  private List<AccessMenuTreeRespDTO> accessHeader;
  /**
   * 可访问路由
   */
  private List<AccessRouteTreeRespDTO> accessRoutes;

  /**
   * 可访问接口
   */
  private List<AccessInterfaceRespDTO> accessInterfaces;

  private String isAdmin = "0";

}
