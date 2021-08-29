package com.xingxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author liuxh
 * @date 2021/8/25
 */
@SpringBootApplication
@EnableAsync
public class TemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class);
    }
}
