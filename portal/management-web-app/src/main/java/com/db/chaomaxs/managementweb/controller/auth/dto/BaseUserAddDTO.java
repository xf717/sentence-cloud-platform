package com.db.chaomaxs.managementweb.controller.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉
 *
 * @author ding
 * @date 2021-03-24 19:50:39
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
@ApiModel(value = "BaseUserAddDTO", description = "添加")
public class BaseUserAddDTO {

  /**
   * 用户名
   */
  @ApiModelProperty(name = "username", value = "用户名")
  @NotNull(message = "用户名不能为空")
  private String username;

  /**
   * 密码
   */
  @ApiModelProperty(name = "password", value = "密码")
  @NotNull(message = "密码不能为空")
  private String password;

  /**
   * 名称
   */
  @ApiModelProperty(name = "name", value = "名称")
  @NotNull(message = "名称为空")
  private String name;

  /**
   * 生日
   */
  @ApiModelProperty(name = "birthday", value = "生日")
  private String birthday;

  /**
   * 地址
   */
  @ApiModelProperty(name = "address", value = "地址")
  private String address;

  /**
   * 手机号码
   */
  @ApiModelProperty(name = "mobilePhone", value = "手机号码")
  private String mobilePhone;

  /**
   * 电话号码
   */
  @ApiModelProperty(name = "telPhone", value = "电话号码")
  private String telPhone;

  /**
   * 邮箱
   */
  @ApiModelProperty(name = "email", value = "email")
  private String email;

  /**
   *
   */
  @ApiModelProperty(name = "sex", value = "性别")
  private String sex;

  /**
   *
   */
  @ApiModelProperty(name = "description", value = "描述")
  private String description;


}
