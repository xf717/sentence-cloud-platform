package com.db.chaomaxs.userservice.rpc.sms.dto;

import com.db.chaomaxs.common.framework.validator.InEnum;
import com.db.chaomaxs.userservice.enums.sms.UserSmsSceneEnum;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户发送短信验证码 Request DTO
 *
 * @author xiaofeng
 */
@Data
@Accessors(chain = true)
public class UserSendSmsCodeReqDTO implements Serializable {

  private static final long serialVersionUID = -5297825351080817914L;
  /**
   * 手机号码
   */
  @NotNull(message = "手机号码不能为空")
  private String mobile;
  /**
   * IP
   */
  @NotNull(message = "IP 不能为空")
  private String ip;
  /**
   * 发送场景
   */
  @NotNull(message = "发送场景不能为空")
  @InEnum(value = UserSmsSceneEnum.class, message = "发送场景不能为空")
  private Integer scene;


  /**
   * 今日发送的第几条
   */
  @NotNull(message = "今日发送的第几条")
  private Integer todayIndex;

  /**
   * 最后一条发送时间，用于计算是否频繁发送短信
   */
  @NotNull(message = "最后一条发送时间，用于计算是否频繁发送短信")
  private Date lastUserSmsCodeTime;

}
