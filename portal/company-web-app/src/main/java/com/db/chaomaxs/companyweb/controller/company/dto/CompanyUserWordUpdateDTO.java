package com.db.chaomaxs.companyweb.controller.company.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 企业常用语表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyUserWordUpdateDTO", description = "更新企业常用语表")
public class CompanyUserWordUpdateDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 主键id
   */
  @ApiModelProperty(name = "id", value = "主键id")
  private Long id;

  /**
   * 企业id
   */
  @ApiModelProperty(name = "companyId", value = "企业id")
  private Long companyId;

  /**
   * 企业用户id
   */
  @ApiModelProperty(name = "companyUserId", value = "企业用户id")
  private Long companyUserId;

  /**
   * 内容
   */
  @ApiModelProperty(name = "content", value = "内容")
  private String content;

  /**
   * 排序
   */
  @ApiModelProperty(name = "sort", value = "排序")
  private Integer sort;

  /**
   * 是否删除 0 - 否 1-是
   */
  @ApiModelProperty(name = "isDeleted", value = "是否删除 0 - 否 1-是")
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
