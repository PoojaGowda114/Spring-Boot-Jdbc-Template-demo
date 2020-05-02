package com.ibm.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	TestService service;

	@RequestMapping("/count")
	int getCountOfUsers() {
		return service.getCountOfUsers();
	}

	@RequestMapping("/users/name/{id}/{address}")
	String getUserName(@PathVariable int id, @PathVariable String address) {
		return service.getUserName(id, address);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users/adduser")
	int addUser(@RequestBody User user) {
		return service.addUser(user.getId(), user.getAddress(), user.getName());
	}

	@RequestMapping("/users/userid/{id}")
	User getUserById(@PathVariable int id) {
		return service.getUserById(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/delete/{id}")
	int deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}

	@RequestMapping("/allusers")
	List<User> listOfUsers() {
		return service.listOfUsers();
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/update/{id}")
	int updateUser(@PathVariable int id, @RequestBody User user) {
		return service.updateUser(id, user);
	}

}