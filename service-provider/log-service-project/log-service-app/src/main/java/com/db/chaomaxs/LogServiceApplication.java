package com.db.chaomaxs;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 日志服务
 *
 * @author momo
 */
@SpringCloudApplication
public class LogServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(LogServiceApplication.class, args);
  }
}
