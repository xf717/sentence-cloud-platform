package com.db.chaomaxs.security.auth.configuration;

import com.db.chaomaxs.security.auth.handler.GlobalExceptionHandler;
import com.db.chaomaxs.security.auth.interceptor.UserAuthRestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiaofeng
 * @date 2017/9/8
 */
@Configuration("admimWebConfig")
@Primary
public class WebConfiguration implements WebMvcConfigurer {

  @Bean
  GlobalExceptionHandler getGlobalExceptionHandler() {
    return new GlobalExceptionHandler();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(getUserAuthRestInterceptor()).addPathPatterns("/service/**");
  }

  @Bean
  UserAuthRestInterceptor getUserAuthRestInterceptor() {
    return new UserAuthRestInterceptor();
  }

  @Bean
  public CorsFilter corsFilter() {
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

  /**
   * 需要用户和服务认证判断的路径
   * @return
   */
//    private ArrayList<String> getIncludePathPatterns() {
//        ArrayList<String> list = new ArrayList<>();
//        String[] urls = {
//                "/element/**",
//                "/gateLog/**",
//                "/group/**",
//                "/groupType/**",
//                "/menu/**",
//                "/user/**",
//                "/api/permissions",
//                "/api/user/un/**",
//                "/service/**"
//        };
//        Collections.addAll(list, urls);
//        return list;
//    }

}
