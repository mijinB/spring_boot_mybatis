package com.codingrecipe.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private String resourcePath = "/upload/**"; // 화면(html)에서 사용할 경로
    private String savePath = "file:///Users/baegmijin/Documents/study/java/codingrecipe/spring_upload_files/"; // 실제 파일 저장 경로
//  private String savePath = "file:///C:/development/intellij_community/spring_upload_files/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourcePath)
                .addResourceLocations(savePath);
    }
}