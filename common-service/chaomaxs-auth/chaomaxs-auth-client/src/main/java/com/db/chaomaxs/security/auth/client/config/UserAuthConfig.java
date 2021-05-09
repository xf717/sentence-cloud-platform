package com.db.chaomaxs.security.auth.client.config;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;

/**
 * 用户权限配置
 *
 * @author xiaofeng
 * @date 2017/9/15
 */
public class UserAuthConfig {

  @Value("${auth.user.token-header}")
  private String tokenHeader;

  private byte[] pubKeyByte;

  public String getTokenHeader() {
    return tokenHeader;
  }

  public void setTokenHeader(String tokenHeader) {
    this.tokenHeader = tokenHeader;
  }

  public String getToken(HttpServletRequest request) {
    return request.getHeader(this.getTokenHeader());
  }

  public byte[] getPubKeyByte() {
    return pubKeyByte;
  }

  public void setPubKeyByte(byte[] pubKeyByte) {
    this.pubKeyByte = pubKeyByte;
  }
}
