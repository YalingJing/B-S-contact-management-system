package com.Jingyalin.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:8080")// 允许域名使用
                .allowedHeaders("*")// 允许任何头
                .allowedMethods("*")// 允许任何方法（post、get等）
                .maxAge(30*1000);
    }
}
