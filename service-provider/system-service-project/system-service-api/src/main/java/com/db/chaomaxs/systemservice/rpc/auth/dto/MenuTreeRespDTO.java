package com.db.chaomaxs.systemservice.rpc.auth.dto;

import com.db.chaomaxs.common.framework.vo.TreeNode;

/**
 * @author xiaofeng
 * @date 2017/6/12
 */
public class MenuTreeRespDTO extends TreeNode {

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

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getComponent() {
    return component;
  }

  public void setComponent(String component) {
    this.component = component;
  }

  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  public String getRedirect() {
    return redirect;
  }

  public void setRedirect(String redirect) {
    this.redirect = redirect;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }


  public MenuTreeRespDTO() {
  }

  public MenuTreeRespDTO(Long id, String name, Long parentId) {
    this.id = id;
    this.parentId = parentId;
    this.title = name;
    this.label = name;
  }

  public MenuTreeRespDTO(Long id, String name, MenuTreeRespDTO parent) {
    this.id = id;
    this.parentId = parent.getId();
    this.title = name;
    this.label = name;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public boolean isSpread() {
    return spread;
  }

  public void setSpread(boolean spread) {
    this.spread = spread;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("MenuTreeRespDTO{");
    sb.append("icon='").append(icon).append('\'');
    sb.append(", title='").append(title).append('\'');
    sb.append(", href='").append(href).append('\'');
    sb.append(", spread=").append(spread);
    sb.append(", path='").append(path).append('\'');
    sb.append(", component='").append(component).append('\'');
    sb.append(", authority='").append(authority).append('\'');
    sb.append(", redirect='").append(redirect).append('\'');
    sb.append(", code='").append(code).append('\'');
    sb.append(", type='").append(type).append('\'');
    sb.append(", label='").append(label).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
