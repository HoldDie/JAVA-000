package com.holddie.geektime.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.holddie.geektime.mall.mapper")
public class MallV11Application {

    public static void main(String[] args) {
        SpringApplication.run(MallV11Application.class, args);
    }

}
