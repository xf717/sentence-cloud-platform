package com.db.chaomaxs.positionservice.rpc.position.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author hlf
 * @version 1.0
 * @description: 职位交接请求类
 * @date 2021/5/6 10:30
 */
@Data
@Accessors(chain = true)
public class CompanyPositionHandoverReqDTO {

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 交接人用户id
   */
  private Long handoverUserId;

}
