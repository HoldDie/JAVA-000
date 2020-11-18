package com.holddie.geektime.bean;

public class CClass {
	private School school;
	private String name;

	public void setSchool(School school) {
		this.school = school;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CClass() {
	}

	public CClass(School school, String name) {
		this.school = school;
		this.name = name;
	}

	public void doing() {
		System.out.println("Class doing");
	}
}
