package com.holddie.geektime.annotationloading;

import com.holddie.geektime.bean.School;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConfig {
    @Bean("school01")
    public School school01() {
        System.out.println("注册Schoole01");
        return new School("第一个5A学校");
    }
}
