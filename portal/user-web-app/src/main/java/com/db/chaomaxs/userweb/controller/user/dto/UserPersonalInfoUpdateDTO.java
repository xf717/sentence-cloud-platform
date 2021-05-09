package com.db.chaomaxs.userweb.controller.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @author wst
 * @date 2021/5/8 9:34
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "UserPersonalInfoUpdateDTO", description = "更新用户个人资料")
public class UserPersonalInfoUpdateDTO {
  /**
   * 用户拓展信息id
   */
  @ApiModelProperty(name ="userExtendId", value = "用户拓展信息id")
  private Long userExtendId;

  /**
   * 用户简历信息id
   */
  @ApiModelProperty(name ="userResumeId", value = "用户简历信息id ")
  private Long userResumeId;

  /**
   * 用户基础信息id
   */
  @ApiModelProperty(name ="userInfoId", value = "用户基础信息id ")
  private Long userInfoId;

  /**
   * 绑定手机
   */
  @ApiModelProperty(name ="mobile" ,value = "绑定手机")
  private String mobile;

  /**
   * 用户头像
   */
  @ApiModelProperty(name ="avatarUrl" ,value = "用户头像")
  private String avatarUrl;

  /**
   * 身份类型:1.职场  2.学生
   */
  @ApiModelProperty(name ="identityType" ,value = "身份类型:1.职场  2.学生")
  private Integer identityType;

  /**
   * 出生年
   */
  @ApiModelProperty(name ="birthdayYear" ,value = "出生年")
  private Integer birthdayYear;

  /**
   * 出身月
   */
  @ApiModelProperty(name ="birthdayMonth" ,value = "出身月")
  private Integer birthdayMonth;

  /**
   * 出生日
   */
  @ApiModelProperty(name ="birthdayDay" ,value = "出生日")
  private Integer birthdayDay;




}
