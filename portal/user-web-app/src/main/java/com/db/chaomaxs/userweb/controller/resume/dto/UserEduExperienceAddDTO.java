package com.db.chaomaxs.userweb.controller.resume.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 *
 * @author wst
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserEduExperienceCreateDTO", description = "添加用户_教育经历表")
public class UserEduExperienceAddDTO {


  /**
   * 学校id，学校字典主键id
   */
  @ApiModelProperty(name = "schoolId", value = "学校id，学校字典主键id")
  private Long schoolId;

  /**
   * 学校
   */
  @ApiModelProperty(name = "schoolName", value = "学校")
  private String schoolName;

  /**
   * 学历ID，字典表主键ID
   */
  @ApiModelProperty(name = "educationDictionaryId", value = "学历ID，字典表主键ID")
  private Long educationDictionaryId;

  /**
   * 学历
   */
  @ApiModelProperty(name = "education", value = "学历")
  private String education;

  /**
   * 专业表ID，从在线上获取的数据
   */
  @ApiModelProperty(name = "specialityId", value = "专业表ID，从在线上获取的数据")
  private Long specialityId;

  /**
   * 专业
   */
  @ApiModelProperty(name = "specialityName", value = "专业")
  private String specialityName;

  /**
   * 在校开始时间
   */
  @ApiModelProperty(name = "beginTime", value = "在校开始时间")
  private String beginTime;

  /**
   * 在校结束时间
   */
  @ApiModelProperty(name = "finishTime", value = "在校结束时间")
  private String finishTime;
}
