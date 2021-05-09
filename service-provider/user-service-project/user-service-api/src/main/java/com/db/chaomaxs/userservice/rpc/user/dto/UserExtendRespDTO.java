package com.db.chaomaxs.userservice.rpc.user.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 用户_基础信息扩展表
 *
 * @author wst
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserExtendRespDTO implements Serializable {

  private static final long serialVersionUID = -9102724191560279348L;
  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
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
  private Integer isEnabledGreet;

  /**
   * 是否启用面试通知:1.是  0.否  默认:1
   */
  private Integer isEnabledInterviewNotice;

  /**
   * 是否启用隐藏简历 0-否  1-是  默认-0
   */
  private Integer isEnabledHide;

  /**
   * 注册ip
   */
  private Integer registerIp;

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

}
