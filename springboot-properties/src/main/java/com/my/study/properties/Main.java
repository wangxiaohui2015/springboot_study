package com.my.study.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

		// Get properties from ConfigurableApplicationContext
		String serverPort = context.getEnvironment().getProperty("server.port");
		System.out.println("Server port: " + serverPort);
	}
}
