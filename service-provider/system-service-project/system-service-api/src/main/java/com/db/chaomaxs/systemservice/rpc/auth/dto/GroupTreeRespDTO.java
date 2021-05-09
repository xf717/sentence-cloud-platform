package com.db.chaomaxs.systemservice.rpc.auth.dto;

import com.db.chaomaxs.common.framework.vo.TreeNode;

/**
 * ${DESCRIPTION}
 *
 * @author xiaofeng
 * @create 2017-06-17 15:21
 */
public class GroupTreeRespDTO extends TreeNode {

  String label;

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
