package com.github.xf717.managementweb.controller.auth.vo;

import com.github.xf717.common.framework.vo.authority.PermissionInfo;
import io.swagger.annotations.ApiModel;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * FrontUserVO
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/02 9:24
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "FrontUserVO", description = "FrontUserVO")
public class FrontUserVO {

  private Long id;
  private String username;
  private String name;
  private String description;
  private String image;
  private List<PermissionInfo> menus;
  private List<PermissionInfo> elements;

}
