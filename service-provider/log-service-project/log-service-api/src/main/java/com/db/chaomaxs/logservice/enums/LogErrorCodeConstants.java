package com.db.chaomaxs.logservice.enums;


import com.db.chaomaxs.common.framework.exception.ErrorCode;

/**
 * 错误码枚举类
 * <p>
 * 错误码区间 [1-004-000-000 ~ 1-004-000-000]
 *
 * @author xiaofeng
 */
public interface LogErrorCodeConstants {


  /**
   * SMS 不存在
   */
  ErrorCode SMS_NOT_EXISTS = new ErrorCode(1004000001, "不存在");
  /**
   * 验证码不存在
   */
  ErrorCode USER_SMS_CODE_NOT_FOUND = new ErrorCode(1004000002, "验证码不存在");

  //---------------用户登录日志----------------//
  ErrorCode USER_LOGIN_LOG_NOT_EXISTS = new ErrorCode(100401001, "用户登录日志不存在");


}
