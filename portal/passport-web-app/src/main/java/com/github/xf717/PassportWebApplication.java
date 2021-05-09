package com.github.xf717;

import com.github.xf717.security.auth.client.EnableAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 求职端服务
 *
 * @author momo, xiaofeng
 */
@SpringCloudApplication
@EnableFeignClients({"com.github.xf717.security.auth.client.rpc.*.facade",
    "com.github.xf717.*.rpc.*.facade"})
@EnableAuthClient
@EnableAsync
public class PassportWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(PassportWebApplication.class, args);
  }
}
