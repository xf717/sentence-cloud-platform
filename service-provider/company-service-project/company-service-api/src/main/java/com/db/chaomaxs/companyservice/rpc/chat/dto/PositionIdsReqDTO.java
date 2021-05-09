package com.db.chaomaxs.companyservice.rpc.chat.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Set;

/**
 * @author momo
 * @date 2021/4/13 10:39
 */

@Data
@Accessors(chain = true)
public class PositionIdsReqDTO implements Serializable {

  private static final long serialVersionUID = 540820711878547965L;
  /**
   * ids
   */
  private Set<Long> ids;

}
