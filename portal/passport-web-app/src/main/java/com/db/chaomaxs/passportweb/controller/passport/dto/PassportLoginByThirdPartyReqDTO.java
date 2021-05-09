package com.db.chaomaxs.passportweb.controller.passport.dto;

import com.db.chaomaxs.common.framework.validator.InEnum;
import com.db.chaomaxs.common.framework.validator.Mobile;
import com.db.chaomaxs.userservice.enums.user.ThirdPartyLoginTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
 * 第三方登录请求参数
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/12 10:55
 */
@ApiModel("用户第三方便登录 Request DTO")
@Data
@Accessors(chain = true)
public class PassportLoginByThirdPartyReqDTO extends AbstractPassportLogin {

  /**
   * 1.小程序登录 2.其它的，等后面看一下情况在说
   */
  @ApiModelProperty(value = "第三方登录类型", required = true, example = "1-小程序序 2-其它待定")
  @Min(value = 1, message = "类型最小值为1")
  @InEnum(ThirdPartyLoginTypeEnum.class)
  private Integer thirdType;

  /**
   * 用户昵称
   */
  @ApiModelProperty(value = "昵称", required = true, example = "梦里花落知多少")
  @NotEmpty(message = "昵称不能为空")
  @Length(min = 4, max = 30, message = "昵称长度为 4-30 位")
  private String nickName;

  /**
   * 用户身份id
   */
  @ApiModelProperty(value = "服务商用户唯一标识", required = true)
  @NotEmpty(message = "服务商用户唯一标识不能为空")
  private String openId;

  /**
   * 用户头像
   */
  @ApiModelProperty(value = "用户头像")
  private String avatarUrl;

  /**
   * 手机号码，第三方授权登录获取到手机号码，如果获取不到跳到手机号码填写绑定页面
   */
  @ApiModelProperty(value = "手机号", required = true, example = "15601691300")
  @NotEmpty(message = "手机号不能为空")
  @Length(max = 11, message = "后机号码最长11位数字")
  @Mobile
  @Pattern(regexp = "^[0-9]+$", message = "手机号必须都是数字")
  private String mobile;

  /**
   * 第三方登录获取的用户信息
   */
  @ApiModelProperty(value = "性别", example = "1",notes = "1-男，2-女，0-未知")
  private Integer sex;


}
