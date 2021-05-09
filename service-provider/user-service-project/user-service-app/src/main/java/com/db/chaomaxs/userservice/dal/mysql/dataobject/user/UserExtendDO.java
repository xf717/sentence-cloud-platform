package com.db.chaomaxs.userservice.dal.mysql.dataobject.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户_基础信息扩展表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_extend")
public class UserExtendDO extends DeletableDO {

  /**
   * 系统id
   */
  private Long id;

  /**
   * 用户信息id
   */
  private Long userId;

  /**
   * email
   */
  private String email;

  /**
   * 微信号
   */
  private String weixin;

  /**
   * 字典:性别(1男、2女、0未知)
   */
  private Integer gender;

  /**
   * 实名
   */
  private String realName;

  /**
   * 身份证
   */
  private String idcard;

  /**
   * 公司id,做为数据隔离
   */
  private Long companyId;

  /**
   * 公司名称
   */
  private String companyName;

  /**
   * 注册时间
   */
  private Date registerTime;

  /**
   * 用户角色 1：求职者  2：招聘者 3:求职和招聘  默认：1
   */
  private Integer userRole;

  /**
   * 身份类型:1.职场  2.学生
   */
  private Integer identityType;

  /**
   * 是否启用打招呼：1.启用  0:未启用 默认:1
   */
  @TableField("is_enabled_greet")
  private Integer enabledGreet;

  /**
   * 是否启用面试通知:1.是  0.否  默认:1
   */
  @TableField("is_enabled_interview_notice")
  private Integer enabledInterviewNotice;

  /**
   * 是否启用隐藏简历 0-否  1-是  默认-0
   */
  @TableField("is_enabled_hide")
  private Integer enabledHide;

  /**
   * 注册ip
   */
  private String registerIp;

  /**
   * 用户注册类型(1邮箱,2手机,3第三方,4批量注册)
   */
  private Integer registerType;

  /**
   * 注册来源：1求职端（默认1）,2企业端
   */
  private Integer registerSource;

  /**
   * 帐号冻结时间
   */
  private Date expireFreeze;

  /**
   * 帐号冻结原因
   */
  private String freezeReason;

  /**
   * 邀请用户id
   */
  private Long invitUserId;

  /**
   * 终端类型(字典:1小程序、2android平板、3pc、4ios手机、5ios平板、6web)
   */
  private Integer terminalType;

  /**
   * 终端唯一
   */
  private String terminalSn;

  /**
   * 终端名称
   */
  private String terminalName;
  /**
   * 简历是否完整 0-否  1-是  默认-0
   */
  @TableField("is_complete_resume")
  private Integer completeResume;


}
