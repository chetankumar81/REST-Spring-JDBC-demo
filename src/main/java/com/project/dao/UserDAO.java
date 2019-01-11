package com.project.dao;

import java.util.List;

import com.project.model.User;

public interface UserDAO {
	List<User> getAllUsers();

	int deleteUser(String userId);
	
	User addUser(User user);
	
	User getUserById(String userId);

	User updateUser(User user);
}
