package com.holddie.geektime.usestartdemo;

import com.holddie.geektime.starter.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UseStartDemoApplication {

	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(UseStartDemoApplication.class, args);
	}

	@GetMapping("/")
	public Object getStudent() {
		try {
			return context.getBean("student1");
		} catch (Exception e) {
			e.printStackTrace();
			return new Student();
		}
	}

}
