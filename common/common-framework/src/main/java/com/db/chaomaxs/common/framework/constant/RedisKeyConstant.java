package com.db.chaomaxs.common.framework.constant;

/**
 * redis 常量
 *
 * @author xiaofeng
 * @create 2020/7/26.
 */
public class RedisKeyConstant {

  public static final String REDIS_KEY_USER_PERMISISON = "admin:permissions:%s";

  public static final String REDIS_KEY_ALL_PERMISISON = "admin:permissions";

  public static final String REDIS_KEY_CAPTCHA = "admin:captcha:%s";

  public static final String REDIS_KEY_TOKEN = "user:token";
}
