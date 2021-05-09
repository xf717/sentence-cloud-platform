package com.db.chaomaxs.managementweb.controller.feedback.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 意见反馈信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "OpinionFeedbackCreateDTO", description = "添加意见反馈信息表")
public class OpinionFeedbackAddDTO {


  /**
   * 反馈人
   */
  @ApiModelProperty(name = "feedbackBy", value = "反馈人")
  private Long feedbackBy;

  /**
   * 反馈人姓名
   */
  @ApiModelProperty(name = "feedbackName", value = "反馈人姓名")
  private String feedbackName;

  /**
   * 反馈手机号码
   */
  @ApiModelProperty(name = "mobile", value = "反馈手机号码")
  private String mobile;

  /**
   * 反馈平台类型(1求职端小程序,2企业端小程序,3企业端PC,4微信)
   */
  @ApiModelProperty(name = "releasePlatformType", value = "反馈平台类型(1求职端,2企业端,3PC,4微信)")
  private Integer releasePlatformType;

  /**
   * 反馈时间
   */
  @ApiModelProperty(name = "releaseTime", value = "反馈时间")
  private Date releaseTime;

  /**
   * 处理状态(0待处理,1处理中,3已处理)
   */
  @ApiModelProperty(name = "handleStatus", value = "处理状态(0待处理,1处理中,3已处理)")
  private Integer handleStatus;

  /**
   * 反馈内容
   */
  @ApiModelProperty(name = "feedbackContent", value = "反馈内容")
  private String feedbackContent;

  /**
   * 图片说明id集合
   */
  @ApiModelProperty(name = "resourceIds", value = "图片说明id集合")
  @Size(max = 3)
  private List<Long> resourceIds;

  /**
   * 处理内容
   */
  @ApiModelProperty(name = "content", value = "处理内容")
  private String content;


}
