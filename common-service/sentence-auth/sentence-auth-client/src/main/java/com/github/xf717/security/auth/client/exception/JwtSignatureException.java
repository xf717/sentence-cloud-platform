package com.github.xf717.security.auth.client.exception;

/**
 * JWT 签名异常
 *
 * @author xiaofeng
 * @date 2017/9/15
 */
public class JwtSignatureException extends Exception {

  public JwtSignatureException(String s) {
    super(s);
  }
}
