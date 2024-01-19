package com.tenco.projectinit._core.config;

import lombok.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//    @Value("${file.path}")
//    private String filePath; // ./images/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

//         1. 절대경로 file:///c:/upload/
//         2. 상대경로 file:./upload/
        registry.addResourceHandler("/images/**") //중요
                .addResourceLocations("file:"+"./images/") //중요
                .addResourceLocations("file:"+"./static/images")
                .setCachePeriod(60*60)// 1시간 중요
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

}