package com.db.chaomaxs.managementweb;

import com.db.chaomaxs.security.auth.client.EnableAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 后台管理系统消费者端
 *
 * @author xiaofeng
 */
@SpringCloudApplication
@EnableFeignClients({"com.db.chaomaxs.security.auth.client.rpc.*.facade",
    "com.db.chaomaxs.*.rpc.*.facade"})
@EnableAuthClient
@EnableAsync
public class ManagementWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(ManagementWebApplication.class, args);
  }

}
