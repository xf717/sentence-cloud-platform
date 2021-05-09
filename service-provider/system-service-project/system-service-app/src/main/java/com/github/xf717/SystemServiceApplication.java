package com.github.xf717;

import com.github.xf717.security.auth.client.EnableAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 系统服务
 *
 * @author xiaofeng
 */
@SpringCloudApplication
@EnableFeignClients({"com.github.xf717.security.auth.client.rpc"})
@EnableAuthClient
public class SystemServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SystemServiceApplication.class, args);
  }

}
