package com.db.chaomaxs;

import com.db.chaomaxs.security.auth.client.EnableAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 企业招聘
 *
 * @author momo, xiaofeng
 */
@SpringCloudApplication
@EnableFeignClients({"com.db.chaomaxs.security.auth.client.rpc.*.facade",
    "com.db.chaomaxs.*.rpc.*.facade"})
@EnableAuthClient
public class CompanyWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(CompanyWebApplication.class, args);
  }
}
