package com.db.chaomaxs.companyweb.controller.company.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author hlf
 * @version 1.0
 * @description: 企业同事修改
 * @date 2021/4/29 14:51
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyColleagueUpdateDTO", description = "企业同事修改")
public class CompanyColleagueUpdateDTO {

  @ApiModelProperty(name = "id", value = "主键id")
  private Long id;

  @ApiModelProperty(name = "userId", value = "用户id")
  private Long userId;

  @ApiModelProperty(name = "bindingState", value = "绑定状态， 0-未绑定，1-已绑定，2-已解绑")
  private Integer bindingState;

}
