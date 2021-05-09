package com.github.xf717.managementweb.controller.auth.dto;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Data
@Accessors(chain = true)
public class BaseGroupDTO {

  /**
   * 角色编码
   */
  private String code;

  /**
   * 角色名称
   */
  private String name;

  /**
   * 上级节点
   */
  private Long parentId;

  /**
   * 树状关系
   */
  private String path;

  /**
   * 类型
   */
  private String type;

  /**
   * 角色组类型
   */
  private Long groupType;





}
