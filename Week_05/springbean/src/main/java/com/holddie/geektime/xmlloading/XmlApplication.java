package com.holddie.geektime.xmlloading;

import com.holddie.geektime.bean.CClass;
import com.holddie.geektime.bean.School;
import com.holddie.geektime.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlApplication {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student124 = (Student) context.getBean("student123");
        System.out.println(student124.toString());

        Student student100 = (Student) context.getBean("student100");
        System.out.println(student100.toString());
        
		CClass class1 = context.getBean(CClass.class);
		System.out.println(class1);
		System.out.println("Klass对象AOP代理后的实际类型："+class1.getClass());
		System.out.println("Klass对象AOP代理后的实际类型是否是Klass子类："+(class1 instanceof CClass));

		School school=(School) context.getBean("school02");
		school.ding();
		System.out.println(school);
		System.out.println("ISchool接口的对象AOP代理后的实际类型："+school.getClass());

		School school1 = context.getBean(School.class);
		school.ding();
		System.out.println(school1);
		System.out.println("ISchool接口的对象AOP代理后的实际类型："+school1.getClass());
        school1.ding();

        class1.doing();

        System.out.println("   context.getBeanDefinitionNames() ===>> "+ String.join(",", context.getBeanDefinitionNames()));


	}
}
