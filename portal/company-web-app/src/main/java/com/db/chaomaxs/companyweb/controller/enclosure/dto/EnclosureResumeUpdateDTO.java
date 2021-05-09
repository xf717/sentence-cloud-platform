package com.db.chaomaxs.companyweb.controller.enclosure.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 企业附件简历
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "EnclosureResumeUpdateDTO", description = "更新企业附件简历")
public class EnclosureResumeUpdateDTO implements Serializable {

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
  private Long companyDeliveryrId;

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
