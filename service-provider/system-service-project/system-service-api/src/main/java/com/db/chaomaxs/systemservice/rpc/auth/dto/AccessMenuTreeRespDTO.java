package com.db.chaomaxs.systemservice.rpc.auth.dto;

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
public class AccessMenuTreeRespDTO extends TreeNode implements Serializable {

  String title;
  String icon;
  String path;
  List<AccessMenuTreeRespDTO> nodes = new ArrayList<AccessMenuTreeRespDTO>();


  @Override
  public void setChildren(List<TreeNode> children) {
    super.setChildren(children);
    nodes = new ArrayList<AccessMenuTreeRespDTO>();
  }

  @Override
  public void add(TreeNode node) {
    super.add(node);
    AccessMenuTreeRespDTO n = new AccessMenuTreeRespDTO();
    BeanUtils.copyProperties(node, n);
    nodes.add(n);
  }
}
