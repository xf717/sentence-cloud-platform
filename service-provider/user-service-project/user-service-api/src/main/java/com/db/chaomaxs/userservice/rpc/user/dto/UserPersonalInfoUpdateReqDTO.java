package com.db.chaomaxs.userservice.rpc.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserPersonalInfoUpdateReqDTO {

  /**
   * 用户拓展信息id
   */
  private Long userExtendId;
  /**
   * 用户简历信息id
   */
  private Long userResumeId;

  /**
   * 用户基础信息id
   */
  private Long userInfoId;

  /**
   * 绑定手机
   */
  private String mobile;

  /**
   * 用户头像
   */
  private String avatarUrl;


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

}
