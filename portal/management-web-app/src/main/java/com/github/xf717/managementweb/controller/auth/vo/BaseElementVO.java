package com.github.xf717.managementweb.controller.auth.vo;

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
@ApiModel(value = "BaseElementVO", description = "")
public class BaseElementVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   *
   */
  @ApiModelProperty(name = "id", value = "")
  private Long id;

  /**
   * 资源编码
   */
  @ApiModelProperty(name = "code", value = "资源编码")
  private String code;

  /**
   * 资源类型
   */
  @ApiModelProperty(name = "type", value = "资源类型")
  private String type;

  /**
   * 资源名称
   */
  @ApiModelProperty(name = "name", value = "资源名称")
  private String name;

  /**
   * 资源路径
   */
  @ApiModelProperty(name = "uri", value = "资源路径")
  private String uri;

  /**
   * 资源关联菜单
   */
  @ApiModelProperty(name = "menuId", value = "资源关联菜单")
  private Long menuId;

  /**
   *
   */
  @ApiModelProperty(name = "parentId", value = "")
  private Long parentId;

  /**
   * 资源树状检索路径
   */
  @ApiModelProperty(name = "path", value = "资源树状检索路径")
  private String path;

  /**
   * 资源请求类型
   */
  @ApiModelProperty(name = "method", value = "资源请求类型")
  private String method;

  /**
   * 描述
   */
  @ApiModelProperty(name = "description", value = "描述")
  private String description;

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
