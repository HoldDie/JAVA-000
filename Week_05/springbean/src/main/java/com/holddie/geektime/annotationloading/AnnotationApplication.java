package com.holddie.geektime.annotationloading;

import com.holddie.geektime.bean.School;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApplication {

    public static void main(String[] args) {
        System.out.println("获取配置前配置");
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        System.out.println("配置后");
        School school = (School) context.getBean("school01");
        school.ding();
    }
}
