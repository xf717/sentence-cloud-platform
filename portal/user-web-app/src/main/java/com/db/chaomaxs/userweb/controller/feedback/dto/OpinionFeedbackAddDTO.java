package com.db.chaomaxs.userweb.controller.feedback.dto;

import com.db.chaomaxs.common.framework.util.base.annotation.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotBlank;
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
   * 反馈平台类型(1求职端小程序,2企业端小程序,3企业端PC,4微信)
   */
  @ApiModelProperty(name = "releasePlatformType", value = "反馈平台类型(1职端,2企业端,3PC,4微信)" ,example = "1,2,3,4")
  @NotNull
  private Integer releasePlatformType;


  /**
   * 反馈内容
   */
  @ApiModelProperty(name = "feedbackContent", value = "反馈内容")
  @NotBlank(message="反馈平台内容不能为空")
  private String feedbackContent;

  /**
   * 图片说明id集合
   */
  @ApiModelProperty(name = "resourceIds", value = "图片说明资源id集合")
  @Size(max = 3)
  private List<Long> resourceIds;


}
