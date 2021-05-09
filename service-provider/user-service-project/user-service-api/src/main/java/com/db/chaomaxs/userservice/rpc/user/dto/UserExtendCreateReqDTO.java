package com.db.chaomaxs.userservice.rpc.user.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;





/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性，
 * 比如：create_time、update_time、create_by、update_by 就可以去掉,
 * 验证添加要自行调整@NotEmpty 自行配置
 * 用户_基础信息扩展表
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserExtendCreateReqDTO implements Serializable {


  /**
   * 用户信息id
   */
  private Long userId;

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
   * 用户注册类型(1邮箱,2手机,3第三方,4批量注册)
   */
  private Integer registerType;

  /**
   * 注册来源：1求职端（默认1）,2企业端
   */
  private Integer registerSource;

  /**
   * 终端类型(字典:1小程序、2android平板、3pc、4ios手机、5ios平板、6web)
   */
  private Integer terminalType;

  /**
   * 用户头像
   */
  private String avatarUrl;

  /**
   * 出生年
   */
  private Integer birthdayYear;

  /**
   * 出身月
   */
  private Integer birthdayMonth;

  /**
   * 参加工作时间
   */
  private Integer participateJob;

}
