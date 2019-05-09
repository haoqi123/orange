package com.mr.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 师利梅 on 2019/5/9.
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(new MyInterceptor());
        interceptor.addPathPatterns("/**");//用于添加拦截规则
        // 多个拦截器组成一个拦截器链
        // excludePathPatterns 用户排除拦截
        interceptor.excludePathPatterns("login");
        interceptor.excludePathPatterns("register");

    }
}
