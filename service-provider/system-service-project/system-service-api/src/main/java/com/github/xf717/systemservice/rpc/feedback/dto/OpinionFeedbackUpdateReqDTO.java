package com.github.xf717.systemservice.rpc.feedback.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 意见反馈信息表
 *
 * @author xiaofeng
 * @date 2021-03-29 18:18:10
 */
@Data
@Accessors(chain = true)
public class OpinionFeedbackUpdateReqDTO implements Serializable {


  /**
   * 系统id
   */
  private Long id;


  /**
   * 处理状态(0待处理,1处理中,3已处理)
   */

  private Integer handleStatus;


  /**
   * 处理内容
   */

  private String content;


}
