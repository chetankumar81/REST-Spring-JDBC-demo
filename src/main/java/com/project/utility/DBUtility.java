package com.project.utility;

import java.sql.Connection;

import javax.activation.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.configuration.AppConfig;

public class DBUtility {
	private static Connection connection = null;
	
	public DBUtility() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.getBean(DataSource.class);
	
		
	}
	
}
