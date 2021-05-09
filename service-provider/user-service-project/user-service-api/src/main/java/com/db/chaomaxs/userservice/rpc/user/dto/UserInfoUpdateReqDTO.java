package com.db.chaomaxs.userservice.rpc.user.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_帐号信息
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserInfoUpdateReqDTO implements Serializable {


  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long id;

  /**
   * 字典:性别(1男、2女、0未知)
   */
  @NotEmpty
  private Integer gender;

  /**
   * 实名
   */
  @NotEmpty
  private String realName;

  /**
   * 身份类型:1.职场  2.学生
   */
  @NotEmpty
  private Integer identityType;


  private String avatarUrl;

  /**
   * 出生年
   */
  @NotEmpty
  private Integer birthdayYear;

  /**
   * 出身月
   */
  @NotEmpty
  private Integer birthdayMonth;

  /**
   * 参加工作时间
   */
  @NotEmpty
  private Integer participateJob;
}
