package com.github.xf717.userservice.rpc.user.dto;

import com.github.xf717.common.framework.validator.InEnum;
import com.github.xf717.userservice.enums.user.LoginRegisterSourceEnum;
import com.github.xf717.userservice.enums.user.ThirdPartyLoginTypeEnum;
import com.github.xf717.userservice.enums.user.UserLoginTypeEnum;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 创建用户，包括第三方登录的信息
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserInfoCreateReqDTO implements Serializable {

  private static final long serialVersionUID = 4512646204001475960L;
  /**
   * 用户登录类型
   */
  @InEnum(UserLoginTypeEnum.class)
  private Integer userLoginType;

  /**
   * 登录注册来源
   */
  @InEnum(LoginRegisterSourceEnum.class)
  private Integer loginRegisterSource;

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
   * 注册IP
   */
  private String registerIp;

  /**
   * 第三方类型:1.小程序，2：微信公众号 3：支付宝，4.其它
   */
  @InEnum(ThirdPartyLoginTypeEnum.class)
  private Integer thirdType;

  /**
   * 第三方标识
   */
  private String thirdIden;

  /**
   * 头像,冗余字段
   */
  private String avatarUrl;

  /**
   * 性别(1男、2女、0未知),冗余字段
   */
  private Integer gender;


}
