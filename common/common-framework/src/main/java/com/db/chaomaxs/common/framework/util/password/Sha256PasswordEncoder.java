package com.db.chaomaxs.common.framework.util.password;

import java.security.MessageDigest;
import org.apache.commons.codec.binary.Base64;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 加密工具
 *
 * @author xiaofeng
 */
public class Sha256PasswordEncoder implements PasswordEncoder {

  @Override
  public String encode(CharSequence charSequence) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      byte digest[] = md.digest(charSequence.toString().getBytes("UTF-8"));
      return new String(Base64.encodeBase64(digest));
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public boolean matches(CharSequence charSequence, String s) {
    return this.encode(charSequence.toString()).equals(s);
  }
}
