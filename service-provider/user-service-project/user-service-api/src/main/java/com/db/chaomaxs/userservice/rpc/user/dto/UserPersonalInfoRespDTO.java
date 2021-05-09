package com.db.chaomaxs.userservice.rpc.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: UserPersonalInfoRespDTO
 * @author wst
 * @date 2021/4/25 16:50
 */

@Data
@Accessors(chain = true)
public class UserPersonalInfoRespDTO {


  /**
   * 用户id
   */
  private Long id;
  /**
   * 微信号
   */
  private String weixin;


  /**
   * 绑定手机
   */
  private String mobile;

  /**
   * 用户头像
   */
  private String avatarUrl;

  /**
   * 字典:性别(1男、2女、0未知)
   */
  private Integer gender;

  /**
   * 实名
   */
  private String realName;

  /**
   * 身份类型:1.职场  2.学生
   */
  private Integer identityType;

  /**
   * 出生年
   */
  private Integer birthdayYear;

  /**
   * 出身月
   */
  private Integer birthdayMonth;

  /**
   * 出生日
   */
  private Integer birthdayDay;

  /**
   * 参加工作时间
   */
  private Integer participateJob;

  /**
   * 简历是否完整 0-否  1-是  默认-0
   */
  private Integer completeResume;
}
