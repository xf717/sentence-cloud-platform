package com.db.chaomaxs;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 资源服务
 *
 * @author momo, xiaofeng
 */
@SpringCloudApplication
@EnableFeignClients({"com.db.chaomaxs.security.auth.client.rpc.*.facade",
    "com.db.chaomaxs.*.rpc.*.facade"})
//@EnableAuthClient
public class ResourceWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(ResourceWebApplication.class, args);
  }
}
