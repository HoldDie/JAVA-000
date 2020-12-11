package com.holddie.geektime.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.holddie.geektime.mall")
public class MallV3Application {

    public static void main(String[] args) {
        SpringApplication.run(MallV3Application.class, args);
    }

}
