package com.github.xf717.hystrix.config;

import com.github.xf717.hystrix.core.error.FeignErrorDecoder;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FeignConfiguration
 *
 * @author xiaofeng
 * @version 1.0
 * @date 2021/04/21 20:53
 */
@Slf4j
@Configuration
public class FeignConfiguration {

  @Bean
  public ErrorDecoder errorDecoder() {
    return new FeignErrorDecoder();
  }


}
