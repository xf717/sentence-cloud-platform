package com.github.xf717.userservice.rpc.user.dto;

import com.github.xf717.common.framework.validator.InEnum;
import com.github.xf717.userservice.enums.user.LoginRegisterSourceEnum;
import com.github.xf717.userservice.enums.user.ThirdPartyLoginTypeEnum;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 比如：create_time、update_time、create_by、update_by
 * 就可以去掉, 验证添加要自行调整@NotEmpty 自行配置 用户_第三方表
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:47
 */
@Data
@Accessors(chain = true)
public class UserThirdCreateReqDTO implements Serializable {

  private static final long serialVersionUID = -6768071850520026650L;
  /**
   * 登录注册来源
   */
  @InEnum(LoginRegisterSourceEnum.class)
  private Integer loginRegisterSource;
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
   * 注册ip
   */
  private String ip;

  /**
   * 手机号码
   */
  private String mobile;

  /**
   * 用户ID
   */
  private Long userId;

}
