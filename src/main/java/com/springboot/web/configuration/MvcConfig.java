package com.springboot.web.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private final HandlerInterceptor timeInterceptor;

    public MvcConfig(@Qualifier(value = "loadingTimeInterceptor") HandlerInterceptor timeInterceptor) {
        this.timeInterceptor = timeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor).addPathPatterns(
                "/v1/app/bar"
        );
    }
}
