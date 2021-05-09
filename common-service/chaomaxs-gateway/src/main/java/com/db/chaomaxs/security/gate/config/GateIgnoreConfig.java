package com.db.chaomaxs.security.gate.config;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * GateIgnoreConfig
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/29 11:49
 */
@Configuration
@ConfigurationProperties(prefix = "gate")
public class GateIgnoreConfig {

  private List<String> ignores;

  public List<String> getIgnores() {
    return ignores;
  }

  public void setIgnores(List<String> ignores) {
    this.ignores = ignores;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("ignores", ignores)
        .toString();
  }

//  public static void main(String[] args) {
//    String test = "/api/passport/rest/passport/send-sms-code";
//    int index = test.lastIndexOf("/api");
//    System.out.println(test.substring(index));
//  }
}
