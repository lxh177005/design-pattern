package com.xingxin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuxh
 * @date 2021/8/29
 */
@SpringBootApplication
@MapperScan("com.xingxin.dao")
public class DecoratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(DecoratorApplication.class);
    }
}
