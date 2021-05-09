package com.db.chaomaxs.userservice.rpc.user.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @author wst
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserInfoPageReqDTO extends PageParam implements Serializable {

  /**
   * 系统id
   */
  @NotEmpty(message = "系统id")
  private Long userId;

  /**
   * 昵称
   */
  private String nickname;

  /**
   * 密码
   */
  private String password;

  /**
   * 绑定手机
   */
  private String mobile;

  /**
   * 个性签名
   */
  private String signature;

  /**
   * 用户头像
   */
  private String avatarUrl;

  /**
   * 用户状态(1正常、2冻结,默认为1)
   */
  private Integer userStatus;

  /**
   * 用户类型(1普通用户,2企业用户,3,运营用户  默认为1)
   */
  private Integer userType;


}
