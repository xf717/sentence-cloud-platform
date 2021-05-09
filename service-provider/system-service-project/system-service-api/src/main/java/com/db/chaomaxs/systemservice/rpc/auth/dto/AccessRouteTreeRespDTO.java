package com.db.chaomaxs.systemservice.rpc.auth.dto;

import com.alibaba.fastjson.JSONObject;
import com.db.chaomaxs.common.framework.vo.TreeNode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * ${DESCRIPTION}
 *
 * @author xiaofeng
 * @create 2017-06-19 13:03
 */
@Data
public class AccessRouteTreeRespDTO extends TreeNode implements Serializable {

  String name;
  String icon;
  String path;
  String component;
  String componentPath;
  /**
   * "meta": { "title": "系统设置", "cache": true }
   */
  JSONObject meta;

  List<AccessRouteTreeRespDTO> nodes = new ArrayList<AccessRouteTreeRespDTO>();


  @Override
  public void setChildren(List<TreeNode> children) {
    super.setChildren(children);
    nodes = new ArrayList<AccessRouteTreeRespDTO>();
  }

  @Override
  public void add(TreeNode node) {
    super.add(node);
    AccessRouteTreeRespDTO n = new AccessRouteTreeRespDTO();
    BeanUtils.copyProperties(node, n);
    nodes.add(n);
  }

}
