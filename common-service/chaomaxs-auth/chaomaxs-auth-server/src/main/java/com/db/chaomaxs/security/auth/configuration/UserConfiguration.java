package com.db.chaomaxs.security.auth.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaofeng
 * @create 2017/12/26.
 */
@Configuration
@Data
public class UserConfiguration {

  @Value("${jwt.token-header}")
  private String userTokenHeader;
}
