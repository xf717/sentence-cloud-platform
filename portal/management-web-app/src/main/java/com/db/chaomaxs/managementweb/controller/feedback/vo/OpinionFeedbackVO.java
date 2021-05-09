package com.db.chaomaxs.managementweb.controller.feedback.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 意见反馈信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Builder
@Data
@Accessors(chain = true)
@ApiModel(value = "OpinionFeedbackVO", description = "意见反馈信息表")
public class OpinionFeedbackVO {

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 反馈人姓名
   */
  @ApiModelProperty(name = "feedbackBy", value = "反馈人姓名")
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
  private String releasePlatformType;

  /**
   * 反馈时间
   */
  @ApiModelProperty(name = "releaseTime", value = "反馈时间")
  private Date releaseTime;

  /**
   * 处理状态(0待处理,1处理中,3已处理)
   */
  @ApiModelProperty(name = "handleStatus", value = "处理状态(0待处理,1处理中,3已处理)")
  private String handleStatus;


  /**
   * 修改时间
   */
  @ApiModelProperty(name = "updateTime", value = "修改时间")
  private Date updateTime;

  /**
   * 修改人
   */
  @ApiModelProperty(name = "updateName", value = "修改人")
  private String updateName;


  /**
   * 反馈内容
   */
  @ApiModelProperty(name = "feedbackContent", value = "反馈内容")
  private String feedbackContent;

  /**
   * 图片说明路径集合
   */

  @ApiModelProperty(name = "imgs", value = "图片说明路径集合")
  private List<String> imgs;

  /**
   * 处理内容
   */
  @ApiModelProperty(name = "content", value = "处理内容")
  private String content;


}
