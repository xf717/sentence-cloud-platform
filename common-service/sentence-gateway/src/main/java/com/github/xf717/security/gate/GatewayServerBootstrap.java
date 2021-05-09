package com.github.xf717.security.gate;

import com.github.xf717.security.auth.client.EnableAuthClient;
import com.github.xf717.security.gate.utils.DBLog;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xiaofeng
 * @create 2018/3/12.
 */
@SpringCloudApplication
@EnableAuthClient
@EnableFeignClients({"com.github.xf717.security.auth.client.rpc"})
public class GatewayServerBootstrap {

  public static void main(String[] args) {
    DBLog.getInstance().start();
    SpringApplication.run(GatewayServerBootstrap.class, args);
  }
}
