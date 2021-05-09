package com.db.chaomaxs.companyweb.controller.company.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author hlf
 * @description: 企业同事信息
 * @date 2021/4/29 14:51
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CompanyColleagueInfoDTO", description = "企业同事信息")
public class CompanyColleagueInfoDTO {

  @ApiModelProperty(name = "id", value = "主键id")
  private Long id;

  @ApiModelProperty(name = "userId", value = "用户id")
  private Long userId;

  @ApiModelProperty(name = "manager", value = "是否管理员 0-否 1-是")
  private Integer manager;

  @ApiModelProperty(name = "bindingState", value = "绑定状态 0-未绑定  1-已绑定  2-已解绑  3-已拒绝")
  private Integer bindingState;

  @ApiModelProperty(name = "realName", value = "姓名")
  private String realName;

  @ApiModelProperty(name = "photoUrl", value = "用户头像url")
  private String photoUrl;

}
