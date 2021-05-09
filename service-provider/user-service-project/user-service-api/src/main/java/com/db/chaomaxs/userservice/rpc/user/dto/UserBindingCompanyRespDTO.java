package com.db.chaomaxs.userservice.rpc.user.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户_企业绑定
 *
 * @author hlf
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserBindingCompanyRespDTO implements Serializable {

  private static final long serialVersionUID = -8923528429519712779L;

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
   * 绑定状态 0-未绑定  1-已绑定  2-已解绑， 3-已拒绝
   */
  private Integer bindingState;

}
