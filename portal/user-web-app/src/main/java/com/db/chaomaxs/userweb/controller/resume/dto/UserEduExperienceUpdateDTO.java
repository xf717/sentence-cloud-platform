package com.db.chaomaxs.userweb.controller.resume.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 用户_教育经历表
 *
 * @author wst
 * @date 2021-03-29 13:08:14
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserEduExperienceUpdateDTO", description = "更新用户_教育经历表")
public class UserEduExperienceUpdateDTO {

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 用户在线简历id：关联user_resume表主键ID
   */
  @ApiModelProperty(name = "userResumeId", value = "用户在线简历id：关联user_resume表主键ID")
  private Long userResumeId;

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
