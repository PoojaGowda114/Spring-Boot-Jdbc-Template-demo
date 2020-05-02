package com.ibm.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired
	UserDao dao;

	int getCountOfUsers() {
		return dao.getCountOfUsers();
	}

	String getUserName(int id, String address) {
		return dao.getUserName(id, address);
	}

	int addUser(int id, String address, String name) {
		return dao.addUser(id, address, name);
	}

	User getUserById(int id) {
		return dao.getUserById(id);
	}
	
	int deleteUser(int id) {
		return dao.deleteUser(id);
	}

	List<User> listOfUsers() {
		return dao.listOfUsers();
	}

	int updateUser(int id, User user) {
		return dao.updateUser(id, user);
	}

}
