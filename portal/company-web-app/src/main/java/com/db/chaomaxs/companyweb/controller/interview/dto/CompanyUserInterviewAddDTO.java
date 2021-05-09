package com.db.chaomaxs.companyweb.controller.interview.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 企业面试表
 *
 * @author xiaofeng
 * @date 2021-03-26 10:18:33
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyUserInterviewCreateDTO", description = "添加企业面试表")
public class CompanyUserInterviewAddDTO {
  /**
   * 职位id
   */
  @ApiModelProperty(name = "positionId", value = "职位id")
  private Long positionId;

  /**
   * 用户id
   */
  @ApiModelProperty(name = "userId", value = "用户id")
  private Long userId;

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
