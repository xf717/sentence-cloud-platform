package com.db.chaomaxs.security.auth.client.exception;

/**
 * token 超时异常
 *
 * @author xiaofeng
 * @date 2017/9/15
 */
public class JwtTokenExpiredException extends Exception {

  public JwtTokenExpiredException(String s) {
    super(s);
  }
}
