package com.github.xf717.rocketmq.producer.message.sms;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * UserSmsCodeSaveMessage
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/07 11:36
 */
@Data
@Accessors(chain = true)
public class UserSmsCodeSaveMessage {

  public static final String TOPIC = "USER_SMS_CODE_SAVE";

  private String mobile;

  private String code;

  private Integer scene;

  private Integer todayIndex;

  private String createIp;

  private Integer used;


}
