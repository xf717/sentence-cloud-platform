package com.github.xf717.userservice.service.sms;

import com.github.xf717.common.framework.exception.util.ServiceExceptionUtil;
import com.github.xf717.common.framework.util.StringUtils;
import com.github.xf717.common.framework.validator.Mobile;
import com.github.xf717.rocketmq.producer.message.sms.UserSmsCodeSaveMessage;
import com.github.xf717.rocketmq.producer.message.sms.UserSmsCodeUpdateMessage;
import com.github.xf717.sms.config.SmsCodeProperties;
import com.github.xf717.userservice.dal.redis.dao.UserSmsCodeRedisDAO;
import com.github.xf717.userservice.enums.UserErrorCodeConstants;
import com.github.xf717.userservice.mq.producer.UserSmsCodeMqProducer;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 短信发送业务
 *
 * @author xiafeng
 */
@Service
@Validated
public class UserSmsCodeService {

  @Autowired
  private UserSmsCodeRedisDAO userSmsCodeRedisDAO;

  @Autowired
  private UserSmsCodeMqProducer userSmsCodeMqProducer;

  @Autowired
  @Qualifier("smsCodeProperties")
  private SmsCodeProperties properties;

  /**
   * 创建短信验证码，并返回它
   * <p>
   * 注意，不包括发送逻辑
   *
   * @param mobile 手机号
   * @param scene  发送场景
   * @param ip     IP
   * @return 短信验证码
   */
  public String createSmsCode(@Mobile String mobile, Integer scene, String ip, Integer todayIndex,
      Date lastUserSmsCodeTime) {

    if (todayIndex != null && lastUserSmsCodeTime != null) {
      // 超过当天发送的上限。
      if (todayIndex >= properties.getSendMaximumQuantityPerDay()) {
        throw ServiceExceptionUtil.exception(UserErrorCodeConstants.USER_SMS_CODE_EXCEED_SEND_MAXIMUM_QUANTITY_PER_DAY);
      }
      if (System.currentTimeMillis() - lastUserSmsCodeTime.getTime()
          < properties.getSendFrequency()) { // 发送过于频繁
        throw ServiceExceptionUtil.exception(UserErrorCodeConstants.USER_SMS_CODE_SEND_TOO_FAST);
      }
    }
    // TODO 提升，每个 IP 每天可发送数量
    // TODO 提升，每个 IP 每小时可发送数量
    final String code = StringUtils.generateRandomCode(6);
    // 将短信缓存在redis中
    userSmsCodeRedisDAO.set(mobile, code);
    // 将保存短信加入到MQ队列中
    UserSmsCodeSaveMessage message = new UserSmsCodeSaveMessage().setMobile(mobile).setCode(code)
        .setScene(scene).setCreateIp(ip).setUsed(0)
        .setTodayIndex(todayIndex != null ? todayIndex : 1);
    userSmsCodeMqProducer.sendUserSmsCodeSaveMessage(message);
    return code;
  }

  /**
   * 验证短信验证码是否正确。 如果正确，则将验证码标记成已使用 如果错误，则抛出 {@link } 异常
   *
   * @param mobile 手机号
   * @param code   验证码
   * @param ip     IP
   */
  public boolean verifySmsCode(String mobile, String code, Long lastSmsCodeId, String ip,
      Integer used) {
    final String smsCode = this.userSmsCodeRedisDAO.get(mobile);
    if (org.apache.commons.lang3.StringUtils.isEmpty(smsCode)) {
      // 验证码已过期,redis 设置到期时间KEY 失效
      throw ServiceExceptionUtil.exception(UserErrorCodeConstants.USER_SMS_CODE_EXPIRED);
    }
    // 验证码已使用
    final Integer usedValue = 1;
    if (used.equals(usedValue)) {
      throw ServiceExceptionUtil.exception(UserErrorCodeConstants.USER_SMS_CODE_USED);
    }
    if (!smsCode.equals(code)) {
      throw ServiceExceptionUtil.exception(UserErrorCodeConstants.USER_SMS_CODE_NOT_CORRECT);
    }
    // 使用验证码
    UserSmsCodeUpdateMessage message = new UserSmsCodeUpdateMessage().setId(lastSmsCodeId)
        .setUsed(usedValue).setUsedIp(ip).setUsedTime(new Date());
    userSmsCodeMqProducer.sendUserSmsCodeUpdateMessage(message);
    return true;
  }

}
