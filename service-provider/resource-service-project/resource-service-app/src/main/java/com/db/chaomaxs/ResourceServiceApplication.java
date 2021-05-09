package com.db.chaomaxs;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 资源提供者服务
 *
 * @author xiaofeng
 */
@SpringCloudApplication
public class ResourceServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ResourceServiceApplication.class, args);
  }

}
