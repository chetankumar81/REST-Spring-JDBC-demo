package com.project.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.project.model.User;

public interface UserService {
	List<User> getAllUsers();

	int deleteUser(String userId);
	
	User addUser(User user);
	
	User getUserById(String userId);

	User updateUser(User user);
	
}
