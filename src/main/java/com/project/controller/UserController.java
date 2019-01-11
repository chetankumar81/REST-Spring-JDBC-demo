package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.User;
import com.project.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public String getAll() {
		return "Returning complete user list";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody List<User> getUsers() {//REST Endpoint.
 
        List<User> users = userService.getAllUsers();
        return users;
    }
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public @ResponseBody User addUser(@RequestBody User user ) {
		return userService.addUser(user);
	}
	
	@RequestMapping(value = "/user/{Id}", method = RequestMethod.GET)
	public @ResponseBody User getUserById(@PathVariable(value="Id") String userId) {
		return userService.getUserById(userId);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public @ResponseBody User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@RequestMapping(value = "/user/{Id}", method = RequestMethod.DELETE)
	public @ResponseBody int deleteUser(@PathVariable(value="Id") String userId) {
		return userService.deleteUser(userId);
	}
}
