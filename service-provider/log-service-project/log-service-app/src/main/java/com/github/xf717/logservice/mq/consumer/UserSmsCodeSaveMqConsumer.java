package com.github.xf717.logservice.mq.consumer;

import com.github.xf717.logservice.convert.sms.UserSmsCodeConvert;
import com.github.xf717.logservice.dal.mysql.dataobject.sms.UserSmsCodeDO;
import com.github.xf717.logservice.dal.mysql.mapper.sms.UserSmsCodeMapper;
import com.github.xf717.rocketmq.producer.message.sms.UserSmsCodeSaveMessage;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserSmsCodeMqConsumer
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/08 9:49
 */
@Service
@Slf4j
@RocketMQMessageListener(topic = UserSmsCodeSaveMessage.TOPIC, consumerGroup =
    "user-sms-code-consumer-group-" + UserSmsCodeSaveMessage.TOPIC)
public class UserSmsCodeSaveMqConsumer implements RocketMQListener<UserSmsCodeSaveMessage> {

  @Autowired
  private UserSmsCodeMapper userSmsCodeMapper;

  @Override
  public void onMessage(UserSmsCodeSaveMessage userSmsCodeSaveMessage) {

    try {
      log.info("短信消息消费");
      UserSmsCodeDO userSmsCodeDO = UserSmsCodeConvert.INSTANCE.convert(userSmsCodeSaveMessage);
      // 未使用,ip默认设为空
      userSmsCodeDO.setUsedIp("");
      // 先默认为创建时间
      userSmsCodeDO.setUsedTime(new Date());
      int result = userSmsCodeMapper.insert(userSmsCodeDO);
      log.info("短信消息消费保存结果[{}]", result);
    } catch (Exception e) {
      log.error("[UserSmsCodeSaveMqConsumer.onMessage()]消费保存短信信息失败]",
          e.getMessage());
      e.printStackTrace();
    }

  }
}
