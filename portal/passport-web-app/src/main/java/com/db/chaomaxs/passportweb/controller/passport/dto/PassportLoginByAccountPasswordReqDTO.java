package com.db.chaomaxs.passportweb.controller.passport.dto;

import com.db.chaomaxs.common.framework.validator.Mobile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
 * 短信登录请求参数
 *
 * @author xiaofeng
 */
@ApiModel("用户帐号密码登录 Request DTO")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PassportLoginByAccountPasswordReqDTO extends AbstractPassportLogin implements
    Serializable {

  @ApiModelProperty(value = "手机号", required = true, example = "15601691300")
  @NotEmpty(message = "手机号不能为空")
  @Length(max = 11, message = "后机号码最长11位数字")
  @Mobile
  @Pattern(regexp = "^[0-9]+$", message = "手机号必须都是数字")
  private String mobile;

  @ApiModelProperty(value = "密码", required = true, example = "Admin@123456")
  @NotEmpty(message = "密码不能为空")
  @Length(min = 6, max = 20, message = "6-20字母加数字组合")
  @Pattern(regexp = "^[0-9]+$", message = "密码验证字母加数字组合")
  private String password;

}
