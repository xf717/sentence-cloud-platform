package com.db.chaomaxs.managementweb.controller.auth.vo;

import com.db.chaomaxs.common.framework.vo.TreeNode;
import com.db.chaomaxs.systemservice.rpc.auth.dto.MenuTreeRespDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * MenuTreeVO
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/02 12:11
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Accessors(chain = true)
@ApiModel(value = "MenuTreeVO", description = "MenuTreeVO")
public class MenuTreeVO extends TreeNode {

  String icon;
  String title;
  String href;
  Boolean spread;
  String path;
  String component;
  String authority;
  String redirect;
  String code;
  String type;
  String label;

  public MenuTreeVO() {

  }

  public MenuTreeVO(Long id, String name, Long parentId) {
    this.id = id;
    this.parentId = parentId;
    this.title = name;
    this.label = name;
  }

  public MenuTreeVO(Long id, String name, MenuTreeRespDTO parent) {
    this.id = id;
    this.parentId = parent.getId();
    this.title = name;
    this.label = name;
  }

}
