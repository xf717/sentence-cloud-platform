package com.db.chaomaxs.companyservice.rpc.interview.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author hlf
 * @version 1.0
 * @description: 面试信息交接类
 * @date 2021/5/6 10:52
 */
@Data
@Accessors(chain = true)
public class CompanyUserInterviewHandoverReqDTO {

  /**
   * 用户id
   */
  private Long userId;

  /**
   * 交接用户id
   */
  private Long handoverUserId;

}
