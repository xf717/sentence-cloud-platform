package com.db.chaomaxs.userservice.rpc.user.dto;

import com.db.chaomaxs.common.framework.vo.PageParam;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 *
 * @author wst
 * @date 2021-03-29 12:47:47
 */
@Data
@Accessors(chain = true)
public class UserPositionCollectPageReqDTO extends PageParam implements Serializable {

  /**
   * 用户id
   */
  private Long userId;


}
