package com.db.chaomaxs.security.gate;

import com.db.chaomaxs.security.auth.client.EnableAuthClient;
import com.db.chaomaxs.security.gate.utils.DBLog;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xiaofeng
 * @create 2018/3/12.
 */
@SpringCloudApplication
@EnableAuthClient
@EnableFeignClients({"com.db.chaomaxs.security.auth.client.rpc"})
public class GatewayServerBootstrap {

  public static void main(String[] args) {
    DBLog.getInstance().start();
    SpringApplication.run(GatewayServerBootstrap.class, args);
  }
}
