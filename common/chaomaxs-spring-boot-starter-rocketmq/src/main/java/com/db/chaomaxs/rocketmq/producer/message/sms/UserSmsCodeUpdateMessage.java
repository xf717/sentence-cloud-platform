package com.db.chaomaxs.rocketmq.producer.message.sms;

import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * UserSmsCodeUpdateMessage
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/07 20:47
 */
@Data
@Accessors(chain = true)
public class UserSmsCodeUpdateMessage {

  public static final String TOPIC = "USER_SMS_CODE_UPDATE";

  /**
   * 用于更新使用
   */
  private Long id;

  /**
   * 使用状态
   */
  private Integer used;

  /**
   * 使用时间
   */
  private Date usedTime;

  /**
   * 使用IP
   */
  private String usedIp;


}
