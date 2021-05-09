package com.github.xf717.logservice.mq.consumer;

import com.github.xf717.logservice.convert.sms.UserSmsCodeConvert;
import com.github.xf717.logservice.dal.mysql.dataobject.sms.UserSmsCodeDO;
import com.github.xf717.logservice.dal.mysql.mapper.sms.UserSmsCodeMapper;
import com.github.xf717.rocketmq.producer.message.sms.UserSmsCodeUpdateMessage;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserSmsCodeUpdateMqConsumer
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/08 9:49
 */
@Service
@RocketMQMessageListener(topic = UserSmsCodeUpdateMessage.TOPIC, consumerGroup =
    "user-sms-code-consumer-group-" + UserSmsCodeUpdateMessage.TOPIC)
public class UserSmsCodeUpdateMqConsumer implements RocketMQListener<UserSmsCodeUpdateMessage> {

  @Autowired
  private UserSmsCodeMapper userSmsCodeMapper;

  @Override
  public void onMessage(UserSmsCodeUpdateMessage message) {
    UserSmsCodeDO userSmsCodeDO = UserSmsCodeConvert.INSTANCE.convert(message);
    userSmsCodeMapper.updateById(userSmsCodeDO);

  }
}
