package com.my.study.properties.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.study.properties.module.RandomVal;
import com.my.study.properties.module.User1;
import com.my.study.properties.module.User2;
import com.my.study.properties.module.User3;

@RestController
public class TestController {

	@Autowired
	private User1 user1;

	@Autowired
	private User2 user2;

	@Autowired
	private User3 user3;

	@Autowired
	private RandomVal randomVal;

	// Get properties from Environment object
	@Autowired
	private Environment env;

	@RequestMapping("/user1")
	public ResponseEntity<User1> showUser() {
		return new ResponseEntity<>(user1, HttpStatus.OK);
	}

	@RequestMapping("/user2")
	public ResponseEntity<User2> showUser2() {
		return new ResponseEntity<>(user2, HttpStatus.OK);
	}

	@RequestMapping("/port")
	public String getServerPort() {
		return env.getProperty("server.port");
	}

	@RequestMapping("/user3")
	public ResponseEntity<User3> showUser3() {
		return new ResponseEntity<>(user3, HttpStatus.OK);
	}

	@RequestMapping("/random")
	public ResponseEntity<RandomVal> showRandomVals() {
		return new ResponseEntity<>(randomVal, HttpStatus.OK);
	}
}
