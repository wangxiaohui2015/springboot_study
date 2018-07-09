package com.my.study.properties.config;

import org.springframework.context.annotation.PropertySource;

@org.springframework.context.annotation.Configuration
@PropertySource("classpath:customized2.properties")
@PropertySource("classpath:random.properties")
public class Configuration {
}
