package com.db.chaomaxs.userweb.controller.feedback.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 意见反馈信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */

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
   * 反馈时间
   */
  @ApiModelProperty(name = "releaseTime", value = "反馈时间")
  private Date releaseTime;


  /**
   * 反馈内容
   */
  @ApiModelProperty(name = "feedbackContent", value = "反馈内容")
  private String feedbackContent;

  /**
   * 图片说明路径集合
   */

  @ApiModelProperty(name = "imgUrls", value = "图片说明路径集合")
  private List<String> imgUrls;

  /**
   * 处理内容
   */
  @ApiModelProperty(name = "content", value = "处理内容")
  private String content;


}
