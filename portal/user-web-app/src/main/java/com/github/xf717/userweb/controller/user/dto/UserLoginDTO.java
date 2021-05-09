package com.github.xf717.userweb.controller.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 登录帐号信息
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserLoginDTO", description = "求职端用户登录")
public class UserLoginDTO {

  /**
   * 密码
   */
  @ApiModelProperty(name = "password", value = "密码")
  private String password;

  /**
   * 验证码
   */
  @ApiModelProperty(name = "validateCode", value = "验证码")
  private String validateCode;


  /**
   * 手机
   */
  @ApiModelProperty(name = "mobile", value = "手机")
  private String mobile;

  /**
   * app应用市场信息id
   */
  @ApiModelProperty(name = "sysAppMarketId", value = "app应用市场信息id")
  private Integer sysAppMarketId;

  /**
   * 终端类型(字典:1android手机、2android平板、3pc、4ios手机、5ios平板、6web)
   */
  @ApiModelProperty(name = "terminalType", value = "终端类型(字典:1android手机、2android平板、3pc、4ios手机、5ios平板、6web)")
  private Integer terminalType;

  /**
   * 终端唯一
   */
  @ApiModelProperty(name = "terminalSn", value = "终端唯一")
  private String terminalSn;

  /**
   * 终端名称
   */
  @ApiModelProperty(name = "terminalName", value = "终端名称")
  private String terminalName;

  /**
   * app版本号
   */
  @ApiModelProperty(name = "appVersionNo", value = "app版本号")
  private Integer appVersionNo;

  /**
   * app版本名称
   */
  @ApiModelProperty(name = "appVersionName", value = "app版本名称")
  private String appVersionName;

  /**
   * 创建人
   */
  @ApiModelProperty(name = "createBy", value = "创建人")
  private Long createBy;

  /**
   * 创建时间
   */
  @ApiModelProperty(name = "createTime", value = "创建时间")
  private Date createTime;

  /**
   * 修改人
   */
  @ApiModelProperty(name = "updateBy", value = "修改人")
  private Long updateBy;

  /**
   * 修改时间
   */
  @ApiModelProperty(name = "updateTime", value = "修改时间")
  private Date updateTime;

}
