package com.github.xf717.userservice.rpc.user.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @description: UserExtendListRespDTO
 * @author wst
 * @date 2021/4/20 15:55
 */

@Data
@Accessors(chain = true)
public class UserExtendDetailRespDTO implements Serializable {

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 姓名
   */
  private String realName;

  /**
   * 头像资源id
   */
  private String avatarUrl;

  /**
   * 公司id
   */
  private Long companyId;
}
