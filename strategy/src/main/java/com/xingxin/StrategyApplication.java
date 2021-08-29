package com.xingxin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.support.SimpleInstantiationStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuxh
 * @date 2021/8/22
 */
@SpringBootApplication
@MapperScan("com.xingxin.dao")
public class StrategyApplication {
    public static void main(String[] args) {
        SpringApplication.run(StrategyApplication.class, args);

        // 源码
//        new ClassPathXmlApplicationContext("bean.xml");
//        //获取bean资源方式：上下文获取的类型、文件形式、IO形式、字节形式、网络等。。。
//        new SimpleInstantiationStrategy();
    }
}
