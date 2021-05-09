package com.db.chaomaxs.userservice.dal.redis.dao;

import static com.db.chaomaxs.userservice.dal.redis.RedisKeyConstants.USER_SMS_CODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * UserSmsCodeRedisDAO
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/07 13:49
 */
@Repository
public class UserSmsCodeRedisDAO {

  @Autowired
  private StringRedisTemplate redisTemplate;

  /**
   * 设置验证码
   *
   * @param mobile
   * @param code
   */
  public void set(final String mobile, String code) {
    final String key = formatKey(mobile);
    redisTemplate.opsForValue().set(key, code, USER_SMS_CODE.getTimeout());
  }

  /**
   * 根据key 获取验证码
   *
   * @param mobile
   * @return
   */
  public String get(final String mobile) {
    final String key = formatKey(mobile);
    return redisTemplate.opsForValue().get(key);
  }

  /**
   * 格式化KEY
   *
   * @param smsCode
   * @return
   */
  private String formatKey(String smsCode) {
    return String.format(USER_SMS_CODE.getKeyTemplate(), smsCode);
  }

}
