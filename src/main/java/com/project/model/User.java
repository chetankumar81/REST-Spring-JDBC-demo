package com.project.model;


import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String emailId;
	private String password;
	private String phone;
	
	public User() {
		
	}
	
	public User(String userId, String emailId, String password, String phone) {
		this.userId = userId;
		this.emailId = emailId;
		this.password = password;
		this.phone = phone;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public String getPassword() {
		return password;
	}
	public String getPhone() {
		return phone;
	}
	public String getUserId() {
		return userId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
