package com.github.xf717.userservice.rpc.user.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户绑定拓展信息
 *
 * @author hlf
 * @date 2021-03-29 12:47:48
 */
@Data
@Accessors(chain = true)
public class UserBindingTransferReqDTO implements Serializable {

  private static final long serialVersionUID = -263573853648347712L;

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 移交用户id
   */
  private Long transferToUserId;

  /**
   * 公司id
   */
  private Long companyId;
}
