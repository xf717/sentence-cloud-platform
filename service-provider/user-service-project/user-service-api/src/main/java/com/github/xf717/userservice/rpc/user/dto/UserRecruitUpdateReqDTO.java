package com.github.xf717.userservice.rpc.user.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户招聘信息修改类
 *
 * @author hlf
 * @date 2021-04-20 18:04:48
 */
@Data
@Accessors(chain = true)
public class UserRecruitUpdateReqDTO implements Serializable {

  /**
   * 用户id
   */
  @NotEmpty(message = "用户id")
  private Long userId;

  /**
   * 实名
   */
  private String realName;

  /**
   * 邮箱
   */
  private String email;

  /**
   * 职务
   */
  private String position;

  /**
   * 公司id
   */
  @NotEmpty(message = "公司id")
  private Long companyId;

  /**
   * 公司名称
   */
  private String companyName;
}
