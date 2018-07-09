package com.my.study.springboot.mysql.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.my.study.springboot.mysql.dao.IUserDao;
import com.my.study.springboot.mysql.module.User;

@RestController
public class UserController {

	@Autowired
	private IUserDao userDao;

	// Query all users
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		Iterator<User> itUsers = userDao.findAll().iterator();
		List<User> users = new ArrayList<User>();
		while (itUsers.hasNext()) {
			users.add(itUsers.next());
		}
		if (users.isEmpty()) {
			// You many decide to return HttpStatus.NOT_FOUND
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// Query one user by ID
	@RequestMapping(value = "/user/id={id}", method = RequestMethod.GET)
	public ResponseEntity<User> findUserById(@PathVariable("id") int id) {
		User user = userDao.findOne(id);
		if (null == user) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// Query users by name
	@RequestMapping(value = "/user/name={name}", method = RequestMethod.GET)
	public ResponseEntity<List<User>> findUsersByName(@PathVariable("name") String name) {
		List<User> users = userDao.findByNameContaining(name);
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// Add one user
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		if (null != userDao.findOne(user.getId())) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		userDao.save(user);
		HttpHeaders headers = new HttpHeaders();
		// This is to send client a URL of how to get added user
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// Update user by ID
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		User currentUser = userDao.findOne(user.getId());
		if (null == currentUser) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userDao.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// Delete user by ID
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
		User currentUser = userDao.findOne(id);
		if (null == currentUser) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		userDao.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// Delete all users
	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAllUsers() {
		userDao.deleteAll();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
