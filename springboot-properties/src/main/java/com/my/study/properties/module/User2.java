package com.my.study.properties.module;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
// Specify properties file to use
@PropertySource("classpath:customized.properties")
public class User2 {
	// Use @Value annotation to inject properties
	@Value("${user2.name}")
	private String name;
	@Value("${user2.age}")
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
