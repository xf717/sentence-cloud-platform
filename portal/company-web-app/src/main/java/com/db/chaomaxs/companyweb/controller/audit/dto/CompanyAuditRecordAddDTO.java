package com.db.chaomaxs.companyweb.controller.audit.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 公司_审核记录信息表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyAuditRecordCreateDTO", description = "添加公司_审核记录信息表")
public class CompanyAuditRecordAddDTO {

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 审核人ID
   */
  @ApiModelProperty(name = "userId", value = "审核人ID")
  private Long userId;

  /**
   * 审核人名称
   */
  @ApiModelProperty(name = "userName", value = "审核人名称")
  private String userName;

  /**
   * 公司ID
   */
  @ApiModelProperty(name = "companyId", value = "公司ID")
  private Long companyId;

  /**
   * 审核状态 0-未审核  1-已审核  2- 审核未通过
   */
  @ApiModelProperty(name = "auditStatus", value = "审核状态 0-未审核  1-已审核  2- 审核未通过")
  private Integer auditStatus;

  /**
   * 审核描述
   */
  @ApiModelProperty(name = "description", value = "审核描述")
  private String description;

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
