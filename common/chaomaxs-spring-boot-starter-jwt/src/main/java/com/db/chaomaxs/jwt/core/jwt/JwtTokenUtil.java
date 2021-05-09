package com.db.chaomaxs.jwt.core.jwt;

import com.db.chaomaxs.common.framework.jwt.IJWTInfo;
import com.db.chaomaxs.common.framework.jwt.JWTHelper;
import com.db.chaomaxs.jwt.config.KeyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xiaofeng
 * @date 2017/9/10
 */
@Component
public class JwtTokenUtil {

  @Value("${jwt.expire}")
  public int expire;
  @Autowired
  private KeyConfiguration keyConfiguration;

  public String generateToken(IJWTInfo jwtInfo) throws Exception {
    return JWTHelper.generateToken(jwtInfo, keyConfiguration.getUserPriKey(), expire);
  }

  public IJWTInfo getInfoFromToken(String token) throws Exception {
    return JWTHelper.getInfoFromToken(token, keyConfiguration.getUserPubKey());
  }


}
