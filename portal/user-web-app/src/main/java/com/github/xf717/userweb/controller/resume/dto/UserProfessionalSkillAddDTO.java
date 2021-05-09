package com.github.xf717.userweb.controller.resume.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户_专业技能表
 *
 * @author wst
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserProfessionalSkillCreateDTO", description = "添加用户_专业技能表")
public class UserProfessionalSkillAddDTO {


  /**
   * 用户id
   */
  @ApiModelProperty(name = "userResumeId", value = "用户id")
  private Long userResumeId;

  /**
   * 技能名称
   */
  @ApiModelProperty(name = "skillName", value = "技能名称")
  private String skillName;

  /**
   * 使用时长
   */
  @ApiModelProperty(name = "durationNum", value = "使用时长")
  private Integer durationNum;

  /**
   * 掌握程度，关联字典表id
   */
  @ApiModelProperty(name = "masteryDictionaryId", value = "掌握程度，关联字典表id")
  private Long masteryDictionaryId;


}
