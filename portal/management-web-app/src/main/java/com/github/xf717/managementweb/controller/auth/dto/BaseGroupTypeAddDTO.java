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
@ApiModel(value = "BaseGroupTypeCreateDTO", description = "添加")
public class BaseGroupTypeAddDTO {

  /**
   *
   */
  @ApiModelProperty(name = "id", value = "")
  private Integer id;

  /**
   * 编码
   */
  @ApiModelProperty(name = "code", value = "编码")
  private String code;

  /**
   * 类型名称
   */
  @ApiModelProperty(name = "name", value = "类型名称")
  private String name;

  /**
   * 描述
   */
  @ApiModelProperty(name = "description", value = "描述")
  private String description;

  /**
   * 创建主机
   */
  @ApiModelProperty(name = "crtHost", value = "创建主机")
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
