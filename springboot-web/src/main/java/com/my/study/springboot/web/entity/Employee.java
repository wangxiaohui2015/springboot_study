package com.my.study.springboot.web.entity;

/**
 * Entity Object
 */
public class Employee {
	private int id;
	private String name;
	private int age;
	private String desc;

	public Employee() {
	}

	public Employee(int id, String name, int age, String desc) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
