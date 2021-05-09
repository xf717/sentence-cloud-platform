package com.db.chaomaxs;

import com.db.chaomaxs.security.auth.client.EnableAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 职位库服务
 *
 * @author xiaofeng
 */
@SpringCloudApplication
@EnableFeignClients({"com.db.chaomaxs.security.auth.client.rpc"})
@EnableAuthClient
public class PositionServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(PositionServiceApplication.class, args);
  }
}
