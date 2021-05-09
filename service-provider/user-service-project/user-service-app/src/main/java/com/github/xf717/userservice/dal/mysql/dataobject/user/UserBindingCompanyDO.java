package com.github.xf717.userservice.dal.mysql.dataobject.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.xf717.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户_企业绑定
 *
 * @author hlf
 * @date 2021-03-29 12:47:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_binding_company")
public class UserBindingCompanyDO extends DeletableDO {

  /**
   * 主键id
   */
  private Long id;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 是否管理员 0-否  1-是  默认-0
   */
  @TableField("is_manager")
  private Integer manager;

  /**
   * 公司id,做为数据隔离
   */
  private Long companyId;

  /**
   * 绑定状态 0-未绑定  1-已绑定  2-已解绑， 3-已拒绝 默认:1
   */
  private Integer bindingState;

  /**
   * 是否已交接，0-否，1-是  默认：0
   */
  @TableField("is_handover")
  private Integer handover;

  /**
   * 交接人用户id
   */
  private Long handoverUserId;

}
