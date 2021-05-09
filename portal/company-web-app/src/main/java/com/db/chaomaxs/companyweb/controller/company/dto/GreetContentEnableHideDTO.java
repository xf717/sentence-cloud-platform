package com.db.chaomaxs.companyweb.controller.company.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: 打招呼语按钮开关更新
 * @author wst
 * @date 2021/4/23 16:34
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "GreetContentEnableHideDTO",description = "打招呼语按钮开关更新")
public class GreetContentEnableHideDTO {

  /**
   * 用户信息id
   */
  @ApiModelProperty(name ="userId", value = "用户信息id")
  private Long userId;

  /**
   * 是否启用打招呼：1.启用  0:未启用 默认:1
   */
  @ApiModelProperty(name ="enabledGreet", value = "是否启用打招呼：1.启用  0:未启用 默认:1")
  private Integer enabledGreet;
}
