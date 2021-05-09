package com.db.chaomaxs.security.auth.client.jwt;

import com.db.chaomaxs.common.framework.exception.auth.UserTokenException;
import com.db.chaomaxs.common.framework.jwt.IJWTInfo;
import com.db.chaomaxs.common.framework.jwt.JWTHelper;
import com.db.chaomaxs.security.auth.client.config.UserAuthConfig;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaofeng
 * @date 2017/9/15
 */
@Configuration
public class UserAuthUtil {

  @Autowired
  private UserAuthConfig userAuthConfig;

  public IJWTInfo getInfoFromToken(String token) throws Exception {
    try {
      return JWTHelper.getInfoFromToken(token, userAuthConfig.getPubKeyByte());
    } catch (ExpiredJwtException ex) {
      throw new UserTokenException("User token expired!");
    } catch (SignatureException ex) {
      throw new UserTokenException("User token signature error!");
    } catch (IllegalArgumentException ex) {
      throw new UserTokenException("User token is null or empty!");
    }
  }
}
