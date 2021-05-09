package com.db.chaomaxs.companyweb.service.resume.bo;

import javax.validation.constraints.NotEmpty;
import lombok.Data;
/**
 * @description: UserResumeBO
 * @author wst
 * @date 2021/5/6 16:28
 */

@Data
public class UserResumeInfoBO {

  /**
   * 主键id
   */
  @NotEmpty(message = "主键id")
  private Long id;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 用户发布的职位id
   */
  private Long positionId;


  /**
   * 企业用户id
   */
  private Long companyUserId;
}
