package com.github.xf717.userservice.rpc.user.dto;

import java.io.Serializable;
import java.util.Set;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @author wst
 * @date 2021/4/14 11:02
 */

@Data
@Accessors(chain = true)
public class UserExtendDetailReqDTO implements Serializable {

  private Set<Long> userIds;
}
