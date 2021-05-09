package com.github.xf717.userweb.controller.resume.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @description: 更新用户求职状态
 * @author wst
 * @date 2021/4/29 11:01
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "UserPositionWantedStatusDTO", description = "更新用户求职状态")
public class UserPositionWantedStatusDTO {

  /**
   * 用户简历id
   */
  @ApiModelProperty(name = "userResumeId", value = "用户简历id")
  private Long userResumeId;

  /**
   * 求职状态:关键字典表id
   */
  @ApiModelProperty(name = "positionWantedDictionaryId", value = "求职状态:关键字典表id")
  private Long positionWantedDictionaryId;

  /**
   * 求职状态名称，冗余字段
   */
  @ApiModelProperty(name = "positionWantedStatusName", value = "求职状态名称，冗余字段")
  private String positionWantedStatusName;

}
