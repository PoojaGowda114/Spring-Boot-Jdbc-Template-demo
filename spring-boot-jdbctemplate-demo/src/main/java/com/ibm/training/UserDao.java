package com.ibm.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate template;

	int getCountOfUsers() {
		return template.queryForObject("select count(*) from user", Integer.class);
	}

	String getUserName(int id, String address) {
		return template.queryForObject("select name from user where id = ? and address = ?",
				new Object[] { id, address }, String.class);
	}

	int addUser(int id, String address, String name) {
		return template.update("insert into user values(?, ?, ?)", new Object[] { id, address, name });
	}

	User getUserById(int id) {
		return template.queryForObject("select * from user where id=?", new Object[] { id },
				new BeanPropertyRowMapper<User>(User.class));
	}

	int deleteUser(int id) {
		return template.update("delete from user where id= ?", new Object[] { id });
	}

	List<User> listOfUsers() {
		return template.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
	}

	int updateUser(int id, User user) {
		return template.update("update user set address=?, name=? where id=?",
				new Object[] { user.getAddress(), user.getName(), id });
	}

}
