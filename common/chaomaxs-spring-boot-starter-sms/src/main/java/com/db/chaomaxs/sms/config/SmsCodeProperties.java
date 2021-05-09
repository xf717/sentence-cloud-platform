package com.db.chaomaxs.sms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 短信验证码相关配置
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/07 18:59
 */
@ConfigurationProperties("sms.code")
public class SmsCodeProperties {

  private int expireTimeMillis;
  /**
   * 每日发送最大数量
   */
  private int sendMaximumQuantityPerDay;
  /**
   * 短信发送频率，单位：毫秒
   */
  private int sendFrequency;

  public int getExpireTimeMillis() {
    return expireTimeMillis;
  }

  public SmsCodeProperties setExpireTimeMillis(int expireTimeMillis) {
    this.expireTimeMillis = expireTimeMillis;
    return this;
  }

  public int getSendMaximumQuantityPerDay() {
    return sendMaximumQuantityPerDay;
  }

  public SmsCodeProperties setSendMaximumQuantityPerDay(int sendMaximumQuantityPerDay) {
    this.sendMaximumQuantityPerDay = sendMaximumQuantityPerDay;
    return this;
  }

  public int getSendFrequency() {
    return sendFrequency;
  }

  public SmsCodeProperties setSendFrequency(int sendFrequency) {
    this.sendFrequency = sendFrequency;
    return this;
  }
}
