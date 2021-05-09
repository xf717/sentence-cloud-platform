package com.db.chaomaxs.userservice.rpc.user.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户绑定信息
 *
 * @author hlf
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserBindingInfoRespDTO implements Serializable {

  private static final long serialVersionUID = -8709359140771137024L;
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
   * 是否管理员 0-否  1-是  默认-0
   */
  private Integer manager;

  /**
   * 公司id,做为数据隔离
   */
  private Long companyId;

  /**
   * 绑定状态 0-未绑定  1-已绑定  2-已解绑，3-已拒绝
   */
  private Integer bindingState;

  /**
   * 姓名
   */
  private String realName;

  /**
   * 邮箱
   */
  private String email;

  /**
   * 手机
   */
  private String mobile;

  /**
   * 职务
   */
  private String position;

}
