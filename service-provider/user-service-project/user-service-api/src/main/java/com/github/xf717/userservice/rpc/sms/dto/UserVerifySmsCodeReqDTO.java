package com.github.xf717.userservice.rpc.sms.dto;

import com.github.xf717.common.framework.validator.InEnum;
import com.github.xf717.userservice.enums.sms.UserSmsSceneEnum;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户校验验证码 Request DTO
 *
 * @author xiaofeng
 */
@Data
@Accessors(chain = true)
public class UserVerifySmsCodeReqDTO implements Serializable {

  private static final long serialVersionUID = 7898144815701108617L;
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
   * 验证码
   */
  @NotNull(message = "验证码不能为空")
  private String code;

  @NotNull(message = "id不能为空，用于更新")
  private Long lastSmsCodeId;

  @NotNull(message = "使用值")
  private Integer used;


}
