package com.github.xf717.passportweb.controller.passport.dto;

import com.github.xf717.common.framework.validator.InEnum;
import com.github.xf717.userservice.enums.user.LoginRegisterSourceEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * AbstractPassportLogin
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/15 11:46
 */
@ApiModel("登录注册来源")
public class AbstractPassportLogin {

  /**
   * 登录注册来源
   */
  @ApiModelProperty(value = "登录注册来源，从 1 开始", required = true, example = "1")
  @NotNull(message = "登录来源值不能为空")
  @Min(value = 1, message = "登录来源值最小为 1")
  @InEnum(LoginRegisterSourceEnum.class)
  private Integer loginRegisterSource;

  /**
   * 设备类型
   */
//  @ApiModelProperty(value = "设备类型", required = true, example = "1")
//  @NotNull(message = "设备类型不能为空")
//  @Min(value = 1, message = "最小值为1")
//  @InEnum(TerminalTypeEnum.class)
//  private Integer terminalType;


  public Integer getLoginRegisterSource() {
    return loginRegisterSource;
  }

  public AbstractPassportLogin setLoginRegisterSource(Integer loginRegisterSource) {
    this.loginRegisterSource = loginRegisterSource;
    return this;
  }
}
