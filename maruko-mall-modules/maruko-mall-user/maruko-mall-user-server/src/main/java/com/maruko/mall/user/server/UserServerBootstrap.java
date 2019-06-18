package com.maruko.mall.user.server;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Ace on 2017/6/2.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.maruko.mall.user.server.mapper")
@EnableAutoConfiguration
public class UserServerBootstrap {
	public static void main(String[] args) {
		SpringApplication.run(UserServerBootstrap.class, args);
	}
}
