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
@ApiModel(value = "BaseGroupTypeVO", description = "")
public class BaseGroupTypeVO implements Serializable {

  private static final long serialVersionUID = 1L;

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
