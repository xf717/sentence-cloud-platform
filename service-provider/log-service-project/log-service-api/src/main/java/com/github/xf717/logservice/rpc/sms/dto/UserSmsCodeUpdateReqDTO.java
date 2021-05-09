package com.github.xf717.logservice.rpc.sms.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户短信验证码表
 *
 * @author xiaofeng
 * @date 2021-04-06 17:48:02
 */
@Data
@Accessors(chain = true)
public class UserSmsCodeUpdateReqDTO implements Serializable {


  private static final long serialVersionUID = -2337202000587271936L;
  /**
   *
   */
  @NotEmpty(message = "")
  private Long id;

  /**
   * 手机号码
   */
  private String mobile;

  /**
   * 验证码
   */
  private String code;

  /**
   * 发送场景：1-求职端手机号登陆 2-求职端更换号码  3-企业端登录  4-企业端注册
   */
  private Integer scene;

  /**
   * 今日发送的第几条
   */
  private Integer todayIndex;

  /**
   * 创建IP
   */
  private String createIp;

  /**
   * 消息状态 ：0-未使用  1 -已使用  默认1
   */
  private Integer used;

  /**
   * 使用时间
   */
  private Date usedTime;

  /**
   * 使用IP
   */
  private String usedIp;


}
