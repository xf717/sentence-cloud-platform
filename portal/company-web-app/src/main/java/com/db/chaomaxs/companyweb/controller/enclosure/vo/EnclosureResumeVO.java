package com.db.chaomaxs.companyweb.controller.enclosure.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 企业附件简历
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "EnclosureResumeVO", description = "企业附件简历")
public class EnclosureResumeVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   *
   */
  @ApiModelProperty(name = "id", value = "")
  private Long id;

  /**
   * 企业投递表主键id
   */
  @ApiModelProperty(name = "companyDeliveryrId", value = "企业投递表主键id")
  private Long companyDeliveryId;

  /**
   * 对应资源库id
   */
  @ApiModelProperty(name = "resourceId", value = "对应资源库id")
  private Long resourceId;

  /**
   * 是否删除
   */
  @ApiModelProperty(name = "isDeleted", value = "是否删除")
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
