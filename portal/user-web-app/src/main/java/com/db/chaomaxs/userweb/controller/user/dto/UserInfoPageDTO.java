package com.db.chaomaxs.userweb.controller.user.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 不是所有的属性都需要，用于接收参数，在开发的时候可以自定义属性，这里默认显示所有的属性， 添加了swagger API 配置 比如：create_time、update_time、create_by、update_by
 * 就可以去掉 用户_帐号信息
 *
 * @author xiaofeng
 * @date 2021-03-29 12:47:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "UserInfoPageDTO", description = "分页:用户_帐号信息")
public class UserInfoPageDTO extends PageParam {

	private static final long serialVersionUID = 1L;

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

}
