package com.db.chaomaxs.userweb.controller.user.dto;

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
@ApiModel("设置新密码 Request DTO")
@Data
@Accessors(chain = true)
public class UpdatePasswordReqDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 旧密码
   */
  @ApiModelProperty(value = "旧密码", required = true, example = "Admin@123456")
  @NotEmpty(message = "密码不能为空")
  @Length(min = 6, max = 20, message = "6-20字母加数字组合")
  @Pattern(regexp = "^[0-9]+$", message = "密码验证字母加数字组合")
  private String oldPassword;

  /**
   * 新密码
   */
  @ApiModelProperty(value = "新密码", required = true, example = "Admin@123456")
  @NotEmpty(message = "密码不能为空")
  @Length(min = 6, max = 20, message = "6-20字母加数字组合")
  @Pattern(regexp = "^[0-9]+$", message = "密码验证字母加数字组合")
  private String password;

}
