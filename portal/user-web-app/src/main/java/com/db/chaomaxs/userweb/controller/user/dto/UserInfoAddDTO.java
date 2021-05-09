package com.db.chaomaxs.userweb.controller.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @author wst
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserInfoCreateDTO", description = "添加用户_帐号信息")
public class UserInfoAddDTO {

  /**
   * 系统id
   */
  @ApiModelProperty(name = "userId", value = "系统id")
  private Long userId;

  /**
   * 昵称
   */
  @ApiModelProperty(name = "nickname", value = "昵称")
  private String nickname;

  /**
   * 密码
   */
  @ApiModelProperty(name = "password", value = "密码")
  private String password;

  /**
   * 绑定手机
   */
  @ApiModelProperty(name = "mobile", value = "绑定手机")
  private String mobile;

  /**
   * 个性签名
   */
  @ApiModelProperty(name = "signature", value = "个性签名")
  private String signature;

  /**
   * 用户头像
   */
  @ApiModelProperty(name = "avatarUrl", value = "用户头像")
  private String avatarUrl;

  /**
   * 用户状态(1正常、2冻结,默认为1)
   */
  @ApiModelProperty(name = "userStatus", value = "用户状态(1正常、2冻结,默认为1)")
  private Integer userStatus;

  /**
   * 用户类型(1普通用户,2企业用户,3,运营用户  默认为1)
   */
  @ApiModelProperty(name = "userType", value = "用户类型(1普通用户,2企业用户,3,运营用户  默认为1)")
  private Integer userType;

  /**
   * 公司id,做为数据隔离
   */
  @ApiModelProperty(name = "companyId", value = "公司id,做为数据隔离")
  private Long companyId;
}
