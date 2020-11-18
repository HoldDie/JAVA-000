package com.holddie.geektime.bean;

public class School {

	private String name;

	public School() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public School(String name) {
		this.name = name;
	}

	public void ding() {
		System.out.println("School doing");
	}
}
