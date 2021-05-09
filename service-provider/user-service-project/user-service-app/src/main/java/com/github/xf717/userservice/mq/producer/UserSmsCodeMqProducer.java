package com.github.xf717.userservice.mq.producer;

import com.github.xf717.rocketmq.producer.message.sms.UserSmsCodeSaveMessage;
import com.github.xf717.rocketmq.producer.message.sms.UserSmsCodeUpdateMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * UserSmsCodeMQProducer
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/07 11:25
 */
@Component
@Slf4j
public class UserSmsCodeMqProducer {

  @Autowired
  private RocketMQTemplate rocketMQTemplate;

  /**
   * 发送保存短信消息
   *
   * @param message
   */
  public void sendUserSmsCodeSaveMessage(UserSmsCodeSaveMessage message) {
    try {
      SendResult sendResult = rocketMQTemplate
          .syncSend(UserSmsCodeSaveMessage.TOPIC, message);
      if (!SendStatus.SEND_OK.equals(sendResult.getSendStatus())) {
        log.error("[sendUserSmsCodeSaveMessage][sms_code({}) 发送保存消息失败，结果为({})]",
            message, sendResult);
      }
    } catch (Throwable throwable) {
      log.error("[sendUserSmsCodeSaveMessage][sms_code({}) 发送保存消息失败，发生异常]",
          message, throwable);
    }

  }

  /**
   * 发送更新短信使用消息
   *
   * @param message
   */
  public void sendUserSmsCodeUpdateMessage(UserSmsCodeUpdateMessage message) {
    try {
      SendResult sendResult = rocketMQTemplate
          .syncSend(UserSmsCodeUpdateMessage.TOPIC, message);
      if (!SendStatus.SEND_OK.equals(sendResult.getSendStatus())) {
        log.error("[sendUserSmsCodeUpdateMessage][sms_code({}) 发送更新消息失败，结果为({})]",
            message, sendResult);
      }
    } catch (Throwable throwable) {
      log.error("[sendUserSmsCodeUpdateMessage][sms_code({}) 发送更新消息失败，发生异常]",
          message, throwable);
    }
  }


}
