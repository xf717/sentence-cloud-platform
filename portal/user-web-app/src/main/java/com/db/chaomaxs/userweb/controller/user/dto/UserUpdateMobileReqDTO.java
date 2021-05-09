package com.db.chaomaxs.userweb.controller.user.dto;

import com.db.chaomaxs.common.framework.validator.Mobile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
 * 短信登录请求参数
 *
 * @author xiaofeng
 */
@ApiModel("设置新的手机号码 Request DTO")
@Data
@Accessors(chain = true)
public class UserUpdateMobileReqDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "手机号", required = true, example = "15601691300")
  @NotEmpty(message = "手机号不能为空")
  @Length(max = 11, message = "后机号码最长11位数字")
  @Pattern(regexp = "^[0-9]+$", message = "手机号必须都是数字")
  @Mobile
  private String mobile;

  @ApiModelProperty(value = "手机验证码", required = true, example = "1024")
  @NotEmpty(message = "手机验证码不能为空")
  @Length(min = 4, max = 6, message = "手机验证码长度为 4-6 位")
  @Pattern(regexp = "^[0-9]+$", message = "手机验证码必须都是数字")
  private String code;

  @ApiModelProperty(value = "发送场景", example = "1", notes = "对应 UserSmsSceneEnum 枚举")
  @NotNull(message = "发送场景不能为空")
  private Integer scene;


}
