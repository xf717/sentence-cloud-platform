package com.db.chaomaxs.userservice.dal.redis;

import static com.db.chaomaxs.redis.core.RedisKeyDefine.KeyTypeEnum.STRING;

import com.db.chaomaxs.redis.core.RedisKeyDefine;
import java.time.Duration;

/**
 * RedisKeyConstants
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/07 13:37
 */
public interface RedisKeyConstants {

  /**
   * 短信验证码
   */
  RedisKeyDefine USER_SMS_CODE = new RedisKeyDefine("sms_code:%s", STRING, String.class,
      Duration.ofMillis(60000));


  RedisKeyDefine USER_SIGN_RECORD = new RedisKeyDefine("sign_record:%d:%s", STRING, String.class,Duration.ofHours(24));

}
