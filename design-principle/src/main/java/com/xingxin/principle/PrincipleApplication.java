package com.xingxin.principle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author liuxh
 * @date 2021/9/5
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PrincipleApplication {
    public static void main(String[] args) {
        SpringApplication.run(PrincipleApplication.class);
    }
}
