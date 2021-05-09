package com.db.chaomaxs.userservice.rpc.resume.dto;

import java.io.Serializable;
import java.util.Set;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wst
 * @date 2021/4/13 10:39
 */

@Data
@Accessors(chain = true)
public class UserIdsReqDTO implements Serializable {

  private static final long serialVersionUID = 540820711878547965L;
  /**
   * 用户ids
   */
  private Set<Long> userIds;

}
