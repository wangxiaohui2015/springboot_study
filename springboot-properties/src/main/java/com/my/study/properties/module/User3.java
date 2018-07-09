package com.my.study.properties.module;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
// No need to specify properties file here, because Configuration.java contains
// this clarification.
// Use @ConfigurationProperties to inject user3.name and user3.age to this class
@ConfigurationProperties(prefix = "user3")
public class User3 {
	// No need to add @Value annotation here
	private String name;
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
