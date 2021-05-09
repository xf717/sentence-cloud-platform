package com.db.chaomaxs.userservice.rpc.user.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户_基础信息扩展表
 *
 * @author wst
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserExtendUpdateEnableHideReqDTO implements Serializable {

  /**
   * 主键id
   */
  private Long id;
  /**
   * 用户信息id
   */
  private Long userId;

  /**
   * 是否启用隐藏简历 0-否  1-是  默认-0
   */
  private Integer enabledHide;

  /**
   * 是否启用打招呼：1.启用  0:未启用 默认:1
   */
  private Integer enabledGreet;

  /**
   * 是否启用面试通知:1.是  0.否  默认:1
   */
  private Integer enabledInterviewNotice;
}
