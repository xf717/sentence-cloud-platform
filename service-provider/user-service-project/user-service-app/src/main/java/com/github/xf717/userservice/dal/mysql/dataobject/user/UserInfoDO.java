package com.github.xf717.userservice.dal.mysql.dataobject.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.xf717.mybatis.core.dataobject.DeletableDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 用户_帐号信息
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_info")
public class UserInfoDO extends DeletableDO {

  /**
   * 系统id
   */
  private Long id;

  /**
   * 昵称
   */
  private String nickname;

  /**
   * 密码
   */
  private String password;

  /**
   * 绑定手机
   */
  private String mobile;

  /**
   * 个性签名
   */
  private String signature;

  /**
   * 用户头像
   */
  private String avatarUrl;

  /**
   * 用户状态(1正常、2冻结,默认为1)
   */
  private Integer userStatus;

  /**
   * 用户类型(1普通用户,2企业用户,3,运营用户  默认为1)
   */
  private Integer userType;

  /**
   * 公司id,做为数据隔离
   */
  private Long companyId;


}
