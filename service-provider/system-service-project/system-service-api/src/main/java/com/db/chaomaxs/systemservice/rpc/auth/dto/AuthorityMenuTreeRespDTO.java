package com.db.chaomaxs.systemservice.rpc.auth.dto;

import com.db.chaomaxs.common.framework.vo.TreeNode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;

/**
 * ${DESCRIPTION}
 *
 * @author xiaofeng
 * @create 2017-06-19 13:03
 */
public class AuthorityMenuTreeRespDTO extends TreeNode implements Serializable {

  String text;
  List<AuthorityMenuTreeRespDTO> nodes = new ArrayList<AuthorityMenuTreeRespDTO>();
  String icon;

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public AuthorityMenuTreeRespDTO(String text, List<AuthorityMenuTreeRespDTO> nodes) {
    this.text = text;
    this.nodes = nodes;
  }

  public AuthorityMenuTreeRespDTO() {
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public List<AuthorityMenuTreeRespDTO> getNodes() {
    return nodes;
  }

  public void setNodes(List<AuthorityMenuTreeRespDTO> nodes) {
    this.nodes = nodes;
  }

  @Override
  public void setChildren(List<TreeNode> children) {
    super.setChildren(children);
    nodes = new ArrayList<AuthorityMenuTreeRespDTO>();
  }

  @Override
  public void add(TreeNode node) {
    super.add(node);
    AuthorityMenuTreeRespDTO n = new AuthorityMenuTreeRespDTO();
    BeanUtils.copyProperties(node, n);
    nodes.add(n);
  }
}
