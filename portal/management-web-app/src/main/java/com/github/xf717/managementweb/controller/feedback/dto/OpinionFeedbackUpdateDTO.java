package com.github.xf717.managementweb.controller.feedback.dto;

import com.github.xf717.common.framework.util.base.annotation.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "OpinionFeedbackUpdateDTO", description = "更新意见反馈信息表")
public class OpinionFeedbackUpdateDTO {

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  @NotNull
  private Long id;


  /**
   * 处理状态(0待处理,1处理中,3已处理)
   */
  @ApiModelProperty(name = "handleStatus", value = "处理状态(0待处理,1处理中,3已处理)")
  @NotNull
  private Integer handleStatus;


  /**
   * 处理内容
   */
  @ApiModelProperty(name = "content", value = "处理内容")
  @NotNull
  private String content;


}
