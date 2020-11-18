package com.holddie.geektime.starter;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@AutoConfigureBefore(Student.class)
@EnableConfigurationProperties(Student.class)
@ConditionalOnProperty(prefix = "custom.student", name = "enable", havingValue = "true", matchIfMissing = true)
public class StudentConfiguration {
    
    @Bean("student1")
    public Map getBean(Student student) {
        Map result = new HashMap<String, String>();
        result.put("ID", student.getId());
        result.put("name", student.getName());
        return result;
    }

}
