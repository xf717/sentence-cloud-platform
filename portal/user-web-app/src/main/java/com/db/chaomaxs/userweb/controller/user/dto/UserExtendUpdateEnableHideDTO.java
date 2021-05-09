package com.db.chaomaxs.userweb.controller.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @description: 更新用户_基础信息扩展表
 * @author wst
 * @date 2021/4/15 17:20
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "UserExtendUpdateEnableHideDTO",description = "更新用户_基础信息扩展表")
public class UserExtendUpdateEnableHideDTO {


  /**
   * 是否启用隐藏简历 0-否  1-是  默认-0
   */
  @ApiModelProperty(name ="isEnabledHide", value = "是否启用隐藏简历 0-否  1-是  默认-0")
  private Integer enabledHide;

  /**
   * 是否启用打招呼：1.启用  0:未启用 默认:1
   */
  @ApiModelProperty(name ="enabledGreet", value = "是否启用打招呼：1.启用  0:未启用 默认:1")
  private Integer enabledGreet;

  /**
   * 是否启用面试通知:1.是  0.否  默认:1
   */
  @ApiModelProperty(name ="isEnabledHide", value = "是否启用面试通知:1.是  0.否  默认:1")
  private Integer enabledInterviewNotice;

}
