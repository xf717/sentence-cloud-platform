package com.github.xf717.web.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.github.xf717.web.core.handler.GlobalExceptionHandler;
import com.github.xf717.web.core.handler.GlobalResponseBodyHandler;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 公共配置
 *
 * @author xiaofeng
 */
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class CommonWebAutoConfiguration implements WebMvcConfigurer {

  private Logger logger = LoggerFactory.getLogger(getClass());

  // ========== 全局处理器 ==========

  @Bean
  @ConditionalOnMissingBean(GlobalResponseBodyHandler.class)
  public GlobalResponseBodyHandler globalResponseBodyHandler() {
    return new GlobalResponseBodyHandler();
  }

  @Bean
  @ConditionalOnMissingBean(GlobalExceptionHandler.class)
  public GlobalExceptionHandler globalExceptionHandler() {
    logger.info("进入[GlobalExceptionHandler]");
    return new GlobalExceptionHandler();
  }

  // ========== 拦截器相关 ==========

  // ========== 过滤器相关 ==========

  @Bean
  @ConditionalOnMissingBean
  public FilterRegistrationBean<CorsFilter> corsFilter() {
    FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>(
        corsFilterConfigSource());
    return registrationBean;
  }

  /**
   * 拦截器信息
   *
   * @return
   */
  private CorsFilter corsFilterConfigSource() {
    final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
    final CorsConfiguration corsConfiguration = new CorsConfiguration();
    /* 是否允许请求带有验证信息 */
    corsConfiguration.setAllowCredentials(true);
    /* 允许访问的客户端域名 */
    corsConfiguration.addAllowedOrigin("*");
    /* 允许服务端访问的客户端请求头 */
    corsConfiguration.addAllowedHeader("*");
    /* 允许访问的方法名,GET POST等 */
    corsConfiguration.addAllowedMethod("*");
    urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
    return new CorsFilter(urlBasedCorsConfigurationSource);
  }

  // ========== MessageConverter 相关 ==========

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    // 创建 FastJsonHttpMessageConverter 对象
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
    // 自定义 FastJson 配置
    FastJsonConfig fastJsonConfig = new FastJsonConfig();
    // 设置字符集
    fastJsonConfig.setCharset(Charset.defaultCharset());
    // 剔除循环引用,解决 Integer 作为 Key 时，转换为 String 类型，避免浏览器报错
    fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect,
        SerializerFeature.WriteNonStringKeyAsString);
    fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
    // 设置支持的 MediaType
    fastJsonHttpMessageConverter
        .setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
    // 添加到 converters 中 注意，添加到最开头，放在 MappingJackson2XmlHttpMessageConverter 前面
    converters.add(0, fastJsonHttpMessageConverter);
  }


  /**
   * 解决springboot高版本下日期转json时jackson方式不生效问题 使用此方法, 以下 spring-boot: jackson时间格式化 配置 将会失效
   * spring.jackson.time-zone=GMT+8 spring.jackson.date-format=yyyy-MM-dd HH:mm:ss 原因: 会覆盖
   *
   * @EnableAutoConfiguration 关于 WebMvcAutoConfiguration 的配置
   */
  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    ObjectMapper objectMapper = converter.getObjectMapper();

    // 时间格式化
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    // 设置格式化内容
    converter.setObjectMapper(objectMapper);
    converters.add(0, converter);
  }
}
