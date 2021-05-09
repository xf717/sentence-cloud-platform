package com.github.xf717.passportweb.controller.passport.dto;

import com.github.xf717.common.framework.validator.InEnum;
import com.github.xf717.common.framework.validator.Mobile;
import com.github.xf717.userservice.enums.sms.UserSmsSceneEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 发送手机验证码 请求参数
 *
 * @author xiaofeng
 */
@ApiModel("发送手机验证码 Request DTO")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PassportSendSmsReqDTO extends AbstractPassportLogin {

  @ApiModelProperty(value = "手机号", example = "15601691234")
  @Mobile
  private String mobile;
  @ApiModelProperty(value = "发送场景", example = "1", notes = "对应 UserSmsSceneEnum 枚举")
  @NotNull(message = "发送场景不能为空")
  @InEnum(UserSmsSceneEnum.class)
  private Integer scene;

}
