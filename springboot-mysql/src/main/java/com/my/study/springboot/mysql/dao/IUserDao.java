package com.my.study.springboot.mysql.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.my.study.springboot.mysql.module.User;

// No need to define implementation class, just only define an interface
public interface IUserDao extends CrudRepository<User, Integer> {
	List<User> findByNameContaining(String name);
	// Refer to https://docs.spring.io/spring-data/jpa/docs/1.5.1.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
}
