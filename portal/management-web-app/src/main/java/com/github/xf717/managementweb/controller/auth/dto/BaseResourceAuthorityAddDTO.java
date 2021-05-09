package com.github.xf717.managementweb.controller.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
@ApiModel(value = "BaseResourceAuthorityCreateDTO", description = "添加")
public class BaseResourceAuthorityAddDTO {

  /**
   *
   */
  @ApiModelProperty(name = "id", value = "")
  private Long id;

  /**
   * 角色ID
   */
  @ApiModelProperty(name = "authorityId", value = "角色ID")
  private Long authorityId;

  /**
   * 角色类型
   */
  @ApiModelProperty(name = "authorityType", value = "角色类型")
  private String authorityType;

  /**
   * 资源ID
   */
  @ApiModelProperty(name = "resourceId", value = "资源ID")
  private Long resourceId;

  /**
   * 资源类型
   */
  @ApiModelProperty(name = "resourceType", value = "资源类型")
  private String resourceType;

  /**
   *
   */
  @ApiModelProperty(name = "parentId", value = "")
  private Long parentId;

  /**
   *
   */
  @ApiModelProperty(name = "path", value = "")
  private String path;

  /**
   *
   */
  @ApiModelProperty(name = "description", value = "")
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
