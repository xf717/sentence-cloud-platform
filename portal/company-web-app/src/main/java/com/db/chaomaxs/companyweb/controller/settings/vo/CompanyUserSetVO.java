package com.db.chaomaxs.companyweb.controller.settings.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 企业我的设置
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:32
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyUserSetVO", description = "企业我的设置")
public class CompanyUserSetVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 主键id
   */
  @ApiModelProperty(name = "id", value = "主键id")
  private Long id;

  /**
   * 企业用户id
   */
  @ApiModelProperty(name = "companyUserId", value = "企业用户id")
  private Long companyUserId;

  /**
   * 企业id
   */
  @ApiModelProperty(name = "companyId", value = "企业id")
  private Long companyId;

  /**
   * 用户id
   */
  @ApiModelProperty(name = "userId", value = "用户id")
  private Long userId;

  /**
   * 是否拉入黑名单 0 - 否 1 - 是
   */
  @ApiModelProperty(name = "blackSwitch", value = "是否拉入黑名单  0-否 1-是")
  private Integer blackSwitch;

  /**
   * 消息是否置顶 0 - 否 1 - 是
   */
  @ApiModelProperty(name = "topSwitch", value = "消息是否置顶  0-否 1-是")
  private Integer topSwitch;

  /**
   * 是否删除  0 - 否 1 - 是
   */
  @ApiModelProperty(name = "isDeleted", value = "是否删除  0 - 否 1 - 是")
  private Integer isDeleted;

  /**
   * 创建人
   */
  @ApiModelProperty(name = "createBy", value = "创建人")
  private Long createBy;

  /**
   * 创建时间
   */
  @ApiModelProperty(name = "createTime", value = "创建时间")
  private Date createTime;

  /**
   * 修改人
   */
  @ApiModelProperty(name = "updateBy", value = "修改人")
  private Long updateBy;

  /**
   * 修改时间
   */
  @ApiModelProperty(name = "updateTime", value = "修改时间")
  private Date updateTime;
}
