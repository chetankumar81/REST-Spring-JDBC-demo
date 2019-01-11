package com.project.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.configuration.AppConfig;
import com.project.dao.UserDAO;
import com.project.model.User;

public class Test {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserDAO userDao = context.getBean(UserDAO.class);
		
		System.out.println("List of Person is:");
		
		for(User user: userDao.getAllUsers()) {
			System.out.println(user.getEmailId());
		}
		
	}
}
