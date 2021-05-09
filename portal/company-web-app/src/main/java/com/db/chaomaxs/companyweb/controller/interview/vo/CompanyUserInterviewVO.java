package com.db.chaomaxs.companyweb.controller.interview.vo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 企业面试表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyUserInterviewVO", description = "企业面试表")
public class CompanyUserInterviewVO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 主键id
   */
  @ApiModelProperty(name = "id", value = "主键id")
  private Long id;
  /**
   * 职位id
   */
  @ApiModelProperty(name = "positionId", value = "职位id")
  private Long positionId;

  /**
   * 地址
   */
  @ApiModelProperty(name = "interviewAddress", value = "地址")
  private String interviewAddress;

  /**
   * 面试时间
   */
  @ApiModelProperty(name = "interviemTime", value = "面试时间")
  private Date interviemTime;

  /**
   * 职位名
   */
  @ApiModelProperty(name = "positionName", value = "职位名")
  private String positionName;

  /**
   * 手机号
   */
  @ApiModelProperty(name = "mobile", value = "手机号")
  private String mobile;
}
