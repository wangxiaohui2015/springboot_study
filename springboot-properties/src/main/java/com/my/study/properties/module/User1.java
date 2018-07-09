package com.my.study.properties.module;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User1 {
	// Use @Value annotation to inject properties, default to use application.properties
	@Value("${user1.name}")
	private String name;
	@Value("${user1.age}")
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
