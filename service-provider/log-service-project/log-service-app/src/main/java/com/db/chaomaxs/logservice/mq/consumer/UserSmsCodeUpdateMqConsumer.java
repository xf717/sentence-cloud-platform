package com.db.chaomaxs.logservice.mq.consumer;

import com.db.chaomaxs.logservice.convert.sms.UserSmsCodeConvert;
import com.db.chaomaxs.logservice.dal.mysql.dataobject.sms.UserSmsCodeDO;
import com.db.chaomaxs.logservice.dal.mysql.mapper.sms.UserSmsCodeMapper;
import com.db.chaomaxs.rocketmq.producer.message.sms.UserSmsCodeUpdateMessage;
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
