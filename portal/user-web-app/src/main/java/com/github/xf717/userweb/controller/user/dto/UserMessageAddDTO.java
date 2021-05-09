package com.github.xf717.userweb.controller.user.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 用户消息表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserMessageCreateDTO", description = "添加用户消息表")
public class UserMessageAddDTO {

  /**
   *
   */
  @ApiModelProperty(name = "id", value = "")
  private Long id;

  /**
   * 消息id
   */
  @ApiModelProperty(name = "messageId", value = "消息id")
  private Long messageId;

  /**
   * 用户ID
   */
  @ApiModelProperty(name = "userId", value = "用户ID")
  private Long userId;

  /**
   * 修改时间
   */
  @ApiModelProperty(name = "readTime", value = "修改时间")
  private Date readTime;

  /**
   * 0 - 未读 1 - 已读
   */
  @ApiModelProperty(name = "readStatus", value = "0 - 未读 1 - 已读")
  private Integer readStatus;

  /**
   * 是否删除
   */
  @ApiModelProperty(name = "isDeleted", value = "是否删除")
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
