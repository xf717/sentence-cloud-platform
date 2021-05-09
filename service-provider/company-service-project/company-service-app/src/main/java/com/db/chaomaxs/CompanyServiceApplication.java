package com.db.chaomaxs;

import com.db.chaomaxs.security.auth.client.EnableAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 企业服务
 *
 * @author xiaofeng
 * @date 2021/03/21 21:20
 */
@SpringCloudApplication
@EnableFeignClients({"com.db.chaomaxs.security.auth.client.rpc"})
@EnableAuthClient
public class CompanyServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CompanyServiceApplication.class, args);
  }
}
