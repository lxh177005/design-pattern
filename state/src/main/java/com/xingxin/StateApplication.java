package com.xingxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author liuxh
 * @date 2021/9/4
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class StateApplication {
    public static void main(String[] args) {
        SpringApplication.run(StateApplication.class);
    }
}
