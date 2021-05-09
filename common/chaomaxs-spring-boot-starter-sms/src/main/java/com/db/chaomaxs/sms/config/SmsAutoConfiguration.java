package com.db.chaomaxs.sms.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 简单的短信配置
 *
 * @author xiaofeng
 */
@Configuration
// 允许使用 sms.aliyun.enable=false 禁用 sms
@ConditionalOnProperty(prefix = "sms.aliyun", value = "enable", matchIfMissing = true)
@EnableConfigurationProperties({AliyunSmsProperties.class, SmsCodeProperties.class})
public class SmsAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean
  public AliyunSmsProperties aliyunSmsProperties() {
    return new AliyunSmsProperties();
  }

  @Bean
  @ConditionalOnMissingBean
  public SmsCodeProperties smsCodeProperties() {
    return new SmsCodeProperties();
  }
  

}
