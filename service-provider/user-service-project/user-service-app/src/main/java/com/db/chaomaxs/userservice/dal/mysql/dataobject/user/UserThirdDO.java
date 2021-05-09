package com.db.chaomaxs.userservice.dal.mysql.dataobject.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.db.chaomaxs.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户_第三方表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_third")
public class UserThirdDO extends DeletableDO {

  /**
   * 系统id
   */
  private Long id;

  /**
   * 账号id
   */
  private Long userId;

  /**
   * 第三方类型:1.微信，2：支付宝，3：钉钉，4.其它
   */
  private Integer thirdType;

  /**
   * 第三方标识
   */
  private String thirdIden;

  /**
   * 昵称,冗余字段
   */
  private String nickname;

  /**
   * 头像,冗余字段
   */
  private String avatarUrl;

  /**
   * 性别(1男、2女、0未知),冗余字段
   */
  private Integer gender;

  /**
   * 公司id,做为数据隔离
   */
  private Long companyId;

}
