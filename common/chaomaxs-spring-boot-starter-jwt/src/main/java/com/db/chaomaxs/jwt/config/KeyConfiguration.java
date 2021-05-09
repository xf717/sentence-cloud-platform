package com.db.chaomaxs.jwt.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaofeng
 * @create 2017/12/17.
 */
@Configuration
@Data
public class KeyConfiguration {

  @Value("${jwt.rsa-secret}")
  private String userSecret;
  private byte[] userPubKey;
  private byte[] userPriKey;
}
