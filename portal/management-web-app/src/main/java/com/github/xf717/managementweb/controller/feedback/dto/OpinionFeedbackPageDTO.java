package com.github.xf717.managementweb.controller.feedback.dto;

import java.util.Date;

import com.github.xf717.common.framework.vo.PageParam;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 意见反馈信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "OpinionFeedbackPageDTO", description = "分页:意见反馈信息表")
public class OpinionFeedbackPageDTO extends PageParam {


  private static final long serialVersionUID = -2488632277643718096L;
  /**
   * 反馈人
   */
  @ApiModelProperty(name = "feedbackBy", value = "反馈人")
  private Long feedbackBy;


  /**
   * 反馈人名称
   */
  @ApiModelProperty(name = "feedbackName", value = "反馈人名称")
  private String feedbackName;

  /**
   * 反馈手机号码
   */
  @ApiModelProperty(name = "mobile", value = "反馈手机号码")
  private String mobile;

  /**
   * 反馈平台类型(1求职端小程序,2企业端小程序,3企业端PC,4微信)
   */
  @ApiModelProperty(name = "releasePlatformType", value = "反馈平台类型(1求职端小程序,2企业端小程序,3企业端PC,4微信)")
  private Integer releasePlatformType;

  /**
   * 反馈开始时间
   */
  @ApiModelProperty(name = "releaseStartTime", value = "反馈开始时间")
  private Date releaseStartTime;

  /**
   * 反馈结束时间
   */
  @ApiModelProperty(name = "releaseEndTime", value = "反馈结束时间")
  private Date releaseEndTime;

  /**
   * 处理状态(0待处理,1处理中,3已处理)
   */
  @ApiModelProperty(name = "handleStatus", value = "处理状态(0待处理,1处理中,3已处理)")
  private Integer handleStatus;


  /**
   * 编辑开始时间
   */
  @ApiModelProperty(name = "editStartTime", value = "编辑开始时间")
  private Date editStartTime;

  /**
   * 编辑结束时间
   */
  @ApiModelProperty(name = "editEndTime", value = "编辑结束时间")
  private Date editEndTime;


}
