package com.db.chaomaxs.systemservice.rpc.auth.dto;

import com.db.chaomaxs.common.framework.vo.authority.PermissionInfo;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户信息
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/02 9:47
 */
@Data
@Accessors(chain = true)
public class FrontUserRespDTO {
  
  private Long id;
  private String username;
  private String name;
  private String description;
  private String image;
  private List<PermissionInfo> menus;
  private List<PermissionInfo> elements;

}
