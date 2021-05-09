package com.github.xf717.passportweb.controller.passport.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * PassportTokenRespVO
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/06 19:50
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "访问令牌信息", description = "访问令牌信息")
public class PassportTokenRespVO {

  @ApiModelProperty(value = "访问令牌", required = true, example = "001e8f49b20e47f7b3a2de774497cd50")
  private String accessToken;


}
