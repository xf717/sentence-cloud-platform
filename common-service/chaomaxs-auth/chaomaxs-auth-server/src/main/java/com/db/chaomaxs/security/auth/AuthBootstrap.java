package com.db.chaomaxs.security.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringCloudApplication
@MapperScan("com.db.chaomaxs.security.auth.mapper")
@EnableAsync
@EnableFeignClients({"com.db.chaomaxs.security.auth.client.rpc.*.facade"})
public class AuthBootstrap {
	public static void main(String[] args) {
		SpringApplication.run(AuthBootstrap.class, args);
	}
}
