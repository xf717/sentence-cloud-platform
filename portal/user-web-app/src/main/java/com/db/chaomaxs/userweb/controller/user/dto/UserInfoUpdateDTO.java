package com.db.chaomaxs.userweb.controller.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 用户_帐号信息
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserInfoUpdateDTO", description = "更新用户_帐号信息")
public class UserInfoUpdateDTO {


  /**
   * 字典:性别(1男、2女、0未知)
   */
  @ApiModelProperty(name = "gender", value = "字典:性别(1男、2女、0未知)")
  private Integer gender;

  /**
   * 实名
   */
  @ApiModelProperty(name = "realName", value = "实名")
  private String realName;

  /**
   * 身份类型:1.职场  2.学生
   */
  @ApiModelProperty(name = "identityType", value = "身份类型:1.职场  2.学生")
  private Integer identityType;


  @ApiModelProperty(name = "avatarUrl", value = "头像id")
  private String avatarUrl;

  /**
   * 出生年
   */
  @ApiModelProperty(name = "birthdayYear", value = "年")
  private Integer birthdayYear;

  /**
   * 出身月
   */
  @ApiModelProperty(name = "birthdayYear", value = "月")
  private Integer birthdayMonth;

  /**
   * 参加工作时间
   */
  @ApiModelProperty(name = "participateJob", value = "参加工作时间")
  private Integer participateJob;

}
