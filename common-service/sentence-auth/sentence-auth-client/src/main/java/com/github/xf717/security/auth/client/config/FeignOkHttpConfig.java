package com.github.xf717.security.auth.client.config;

import com.github.xf717.security.auth.client.interceptor.OkHttpTokenInterceptor;
import feign.Feign;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FeignOkHttpConfig 自动配置
 *
 * @author xiaofeng
 */
@AutoConfigureBefore(FeignAutoConfiguration.class)
@Configuration
@ConditionalOnClass(Feign.class)
public class FeignOkHttpConfig {

  @Autowired
  OkHttpTokenInterceptor okHttpLoggingInterceptor;

  private int feignOkHttpReadTimeout = 60;
  private int feignConnectTimeout = 60;
  private int feignWriteTimeout = 120;

  @Bean
  public okhttp3.OkHttpClient okHttpClient() {
    return new okhttp3.OkHttpClient.Builder().readTimeout(feignOkHttpReadTimeout, TimeUnit.SECONDS)
        .connectTimeout(feignConnectTimeout, TimeUnit.SECONDS)
        .writeTimeout(feignWriteTimeout, TimeUnit.SECONDS).connectionPool(new ConnectionPool())
        .addInterceptor(okHttpLoggingInterceptor)
        .build();
  }
}
