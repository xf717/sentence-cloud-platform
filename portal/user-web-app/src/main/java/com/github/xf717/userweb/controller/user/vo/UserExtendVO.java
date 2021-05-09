package com.github.xf717.userweb.controller.user.vo;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 用户_基础信息扩展表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserExtendVO", description = "用户_基础信息扩展表")
public class UserExtendVO {

  /**
   * 系统id
   */
  @ApiModelProperty(name = "id", value = "系统id")
  private Long id;

  /**
   * 用户信息id
   */
  @ApiModelProperty(name = "userId", value = "用户信息id")
  private Long userId;

  /**
   * email
   */
  @ApiModelProperty(name = "email", value = "email")
  private String email;

  /**
   * 微信号
   */
  @ApiModelProperty(name = "weixin", value = "微信号")
  private String weixin;

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
   * 身份证
   */
  @ApiModelProperty(name = "idcard", value = "身份证")
  private String idcard;

  /**
   * 公司id,做为数据隔离
   */
  @ApiModelProperty(name = "companyId", value = "公司id,做为数据隔离")
  private Long companyId;

  /**
   * 公司名称
   */
  @ApiModelProperty(name = "companyName", value = "公司名称")
  private String companyName;

  /**
   * 注册时间
   */
  @ApiModelProperty(name = "registerTime", value = "注册时间")
  private Date registerTime;

  /**
   * 用户角色 1：求职者  2：招聘者 3:求职和招聘  默认：1
   */
  @ApiModelProperty(name = "userRole", value = "用户角色 1：求职者  2：招聘者 3:求职和招聘  默认：1  ")
  private Integer userRole;

  /**
   * 身份类型:1.职场  2.学生
   */
  @ApiModelProperty(name = "identityType", value = "身份类型:1.职场  2.学生")
  private Integer identityType;

  /**
   * 是否启用打招呼：1.启用  0:未启用 默认:1
   */
  @ApiModelProperty(name = "isEnabledGreet", value = "是否启用打招呼：1.启用  0:未启用 默认:1")
  private Integer isEnabledGreet;

  /**
   * 是否启用面试通知:1.是  0.否  默认:1
   */
  @ApiModelProperty(name = "isEnabledInterviewNotice", value = "是否启用面试通知:1.是  0.否  默认:1")
  private Integer isEnabledInterviewNotice;

  /**
   * 是否启用隐藏简历 0-否  1-是  默认-0
   */
  @ApiModelProperty(name = "isEnabledHide", value = "是否启用隐藏简历 0-否  1-是  默认-0")
  private Integer isEnabledHide;

  /**
   * 注册ip
   */
  @ApiModelProperty(name = "registerIp", value = "注册ip")
  private Integer registerIp;

  /**
   * 用户注册类型(1邮箱,2手机,3第三方,4批量注册)
   */
  @ApiModelProperty(name = "registerType", value = "用户注册类型(1邮箱,2手机,3第三方,4批量注册)")
  private Integer registerType;

  /**
   * 注册来源：1求职端（默认1）,2企业端
   */
  @ApiModelProperty(name = "registerSource", value = "注册来源：1求职端（默认1）,2企业端")
  private Integer registerSource;

  /**
   * 帐号冻结时间
   */
  @ApiModelProperty(name = "expireFreeze", value = "帐号冻结时间")
  private Date expireFreeze;

  /**
   * 帐号冻结原因
   */
  @ApiModelProperty(name = "freezeReason", value = "帐号冻结原因")
  private String freezeReason;

  /**
   * 邀请用户id
   */
  @ApiModelProperty(name = "invitUserId", value = "邀请用户id")
  private Long invitUserId;

  /**
   * 终端类型(字典:1小程序、2android平板、3pc、4ios手机、5ios平板、6web)
   */
  @ApiModelProperty(name = "terminalType", value = "终端类型(字典:1小程序、2android平板、3pc、4ios手机、5ios平板、6web)")
  private Integer terminalType;

  /**
   * 终端唯一
   */
  @ApiModelProperty(name = "terminalSn", value = "终端唯一")
  private String terminalSn;

  /**
   * 终端名称
   */
  @ApiModelProperty(name = "terminalName", value = "终端名称")
  private String terminalName;


}
