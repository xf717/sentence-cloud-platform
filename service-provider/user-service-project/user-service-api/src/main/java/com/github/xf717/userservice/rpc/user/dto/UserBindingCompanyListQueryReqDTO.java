package com.github.xf717.userservice.rpc.user.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by 就可以去掉
 * 用户_企业绑定
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserBindingCompanyListQueryReqDTO implements Serializable {

  private static final long serialVersionUID = 2534611339073694087L;

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
   * 绑定状态 0-未绑定  1-已绑定  2-已解绑  3-已拒绝  默认:1
   */
  private Integer bindingState;


}
