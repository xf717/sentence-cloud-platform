package com.db.chaomaxs.passportweb.controller.passport.dto;

import com.db.chaomaxs.common.framework.validator.Mobile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
 * 短信登录请求参数
 *
 * @author xiaofeng
 */
@ApiModel("用户短信验证码登陆 Request DTO")
@Data
@Accessors(chain = true)
public class PassportLoginBySmsReqDTO extends AbstractPassportLogin implements Serializable {

  private static final long serialVersionUID = 5901260216804207502L;
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

}
