package com.db.chaomaxs.userservice.dal.redis.dao;

import static com.db.chaomaxs.userservice.dal.redis.RedisKeyConstants.USER_SIGN_RECORD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
/**
 * @description:  UserSignRedisDAO
 * @author wst
 * @date 2021/4/19 18:39
 */

@Repository
public class UserSignRedisDAO {
  @Autowired
  private StringRedisTemplate redisTemplate;


  /**
   * 设置签到
   *
   * @param signTime
   * @param userId
   */
  public void set(final String signTime, Long userId) {
    final String key = formatKey(signTime,userId);
    redisTemplate.opsForValue().set(key, String.valueOf(userId), USER_SIGN_RECORD.getTimeout());
  }

  /**
   * 根据key 获取value
   *
   * @param signTime
   * @return
   */
  public String get(final String signTime,Long userId) {
    final String key = formatKey(signTime,userId);
    return redisTemplate.opsForValue().get(key);
  }

  /**
   *  判断key 是否存在
   * @param key
   * @return
   */
  public boolean exists(String key) {
    return redisTemplate.hasKey(key);
  }


  /**
   * 格式化KEY
   *
   * @param signTime
   * @return
   */
  public String formatKey(String signTime,Long userId) {
    return String.format(USER_SIGN_RECORD.getKeyTemplate(),userId, signTime);
  }
}
