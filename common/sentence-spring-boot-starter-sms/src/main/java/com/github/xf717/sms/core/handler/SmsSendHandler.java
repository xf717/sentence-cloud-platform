package com.github.xf717.sms.core.handler;

/**
 * SmsSendHandler
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/07 18:49
 */
public interface SmsSendHandler {

  /**
   * 发送短信
   * <p>
   * 由于调用第三方接口返回类型无法自定义，只能使用Object
   * </p>
   *
   * @param mobile
   * @param code
   * @return
   */
  boolean sendSms(String mobile, String code);

}
