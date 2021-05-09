package com.github.xf717.security.auth.client.configuration;

import com.github.xf717.security.auth.client.config.ServiceAuthConfig;
import com.github.xf717.security.auth.client.config.UserAuthConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置
 *
 * @author xiaofeng
 * @date 2017/9/15
 */
@Configuration
@ComponentScan({"com.github.xf717.security.auth.client"})
public class AutoConfiguration {

  @Bean
  ServiceAuthConfig getServiceAuthConfig() {
    return new ServiceAuthConfig();
  }

  @Bean
  UserAuthConfig getUserAuthConfig() {
    return new UserAuthConfig();
  }

}
