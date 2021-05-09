package com.db.chaomaxs.security.user.config;

import com.db.chaomaxs.security.auth.client.interceptor.UserAuthRestInterceptor;
import com.db.chaomaxs.web.config.CommonWebAutoConfiguration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author xiaofeng
 */
@Configuration
@AutoConfigureAfter(CommonWebAutoConfiguration.class) //在 CommonWebAutoConfiguration 之后自动配置，保证过滤器的顺序
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class UserSecurityAutoConfiguration implements WebMvcConfigurer {

  private Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * 用户权限拦截
   *
   * @return
   */
  @Bean
  @ConditionalOnMissingBean(UserAuthRestInterceptor.class)
  public UserAuthRestInterceptor getUserAuthRestInterceptor() {
    logger.debug("[getUserAuthRestInterceptor]{}", "获取用户权限拦截");
    return new UserAuthRestInterceptor();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 拦截的URL
    List<String> includePathPatterns = this.getIncludePathPatterns();
    // 忽略的URL地址
    List<String> excludePathPatterns = this.excludePathPatternList();
    // USER 拦截
    registry.addInterceptor(getUserAuthRestInterceptor()).addPathPatterns(includePathPatterns)
        .excludePathPatterns(excludePathPatterns);
  }

  /**
   * 需要用户和服务认证判断的路径
   *
   * @return
   */
  private List<String> getIncludePathPatterns() {
    List<String> list = new ArrayList();
    //"/facade/**"
    String[] urls = {"/rest/**"};
    Collections.addAll(list, urls);
    return list;
  }

  /**
   * 不进行拦截的URL地址
   *
   * @return
   */
  private List<String> excludePathPatternList() {
    List<String> excludePathPatterns = new ArrayList();

    // TODO 后面在看是否要要在提供者服务层获取用户
//    excludePathPatterns.add("/facade/**");

    // swagger
    excludePathPatterns.add("doc.html");
    excludePathPatterns.add("/swagger-resources/**");
    excludePathPatterns.add("/webjars/**");
    excludePathPatterns.add("/v2/**");
    excludePathPatterns.add("/swagger-ui.html/**");

    // TODO 其它需要过滤的URL,后面可以加动态配置
    return excludePathPatterns;
  }
}
