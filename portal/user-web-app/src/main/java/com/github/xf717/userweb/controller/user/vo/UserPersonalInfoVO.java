package com.github.xf717.userweb.controller.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "UserPersonalInfoVO", description = "用户个人资料")
public class UserPersonalInfoVO {

  /**
   * 用户id
   */
  @ApiModelProperty(name ="id", value = "用户id")
  private Long id;

  /**
   * 微信号
   */
  @ApiModelProperty(name ="weixin" ,value = "微信号")
  private String weixin;


  /**
   * 绑定手机
   */
  @ApiModelProperty(name ="mobile" ,value = "绑定手机")
  private String mobile;

  /**
   * 用户头像
   */
  @ApiModelProperty(name ="avatar" ,value = "用户头像")
  private String avatar;

  /**
   * 字典:性别(1男、2女、0未知)
   */
  @ApiModelProperty(name ="gender" ,value = "字典:性别(1男、2女、0未知)")
  private Integer gender;

  /**
   * 实名
   */
  @ApiModelProperty(name ="realName" ,value = "实名")
  private String realName;

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


  /**
   * 参加工作时间
   */
  @ApiModelProperty(name ="participateJob" ,value = "首次参加工作时间")
  private Integer participateJob;
}
