package com.holddie.geektime.bean;

public class Student {
	private String name;
	private String code;
	private int age;

	public Student() {
	}

	public Student(String name, String code, int age) {
		this.name = name;
		this.code = code;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
