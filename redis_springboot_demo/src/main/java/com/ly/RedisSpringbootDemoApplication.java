package com.ly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author ZhangJiuJiu
 */
@SpringBootApplication
@MapperScan("com.ly.mapper")
@EnableCaching
@EnableScheduling
@PropertySource("classpath:user.properties")
public class RedisSpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisSpringbootDemoApplication.class, args);
    }

}
