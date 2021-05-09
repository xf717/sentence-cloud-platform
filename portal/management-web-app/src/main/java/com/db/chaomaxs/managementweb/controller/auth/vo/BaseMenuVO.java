package com.db.chaomaxs.managementweb.controller.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "BaseMenuVO", description = "")
public class BaseMenuVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   *
   */
  @ApiModelProperty(name = "id", value = "")
  private Long id;

  /**
   * 路径编码
   */
  @ApiModelProperty(name = "code", value = "路径编码")
  private String code;

  /**
   * 标题
   */
  @ApiModelProperty(name = "title", value = "标题")
  private String title;

  /**
   * 父级节点
   */
  @ApiModelProperty(name = "parentId", value = "父级节点")
  private Long parentId;

  /**
   * 资源路径
   */
  @ApiModelProperty(name = "href", value = "资源路径")
  private String href;

  /**
   * 图标
   */
  @ApiModelProperty(name = "icon", value = "图标")
  private String icon;

  /**
   *
   */
  @ApiModelProperty(name = "type", value = "")
  private String type;

  /**
   * 排序
   */
  @ApiModelProperty(name = "orderNum", value = "排序")
  private Integer orderNum;

  /**
   * 描述
   */
  @ApiModelProperty(name = "description", value = "描述")
  private String description;

  /**
   * 菜单上下级关系
   */
  @ApiModelProperty(name = "path", value = "菜单上下级关系")
  private String path;

  /**
   * 启用禁用
   */
  @ApiModelProperty(name = "enabled", value = "启用禁用")
  private String enabled;

  /**
   *
   */
  @ApiModelProperty(name = "crtHost", value = "")
  private String crtHost;

  /**
   * 是否删除:1 是  0 否  默认：0
   */
  @ApiModelProperty(name = "isDeleted", value = "是否删除:1 是  0 否  默认：0")
  private Integer isDeleted;

  /**
   * 创建时间
   */
  @ApiModelProperty(name = "createTime", value = "创建时间")
  private Date createTime;

  /**
   * 创建人
   */
  @ApiModelProperty(name = "createBy", value = "创建人")
  private Long createBy;

  /**
   * 修改时间
   */
  @ApiModelProperty(name = "updateTime", value = "修改时间")
  private Date updateTime;

  /**
   * 修改人
   */
  @ApiModelProperty(name = "updateBy", value = "修改人")
  private Long updateBy;


}
