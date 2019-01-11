package com.project.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserId(String.valueOf(rs.getInt("Id")));
		user.setEmailId(rs.getString("email_id"));
		user.setPassword(rs.getString("password"));
		user.setPhone(String.valueOf(rs.getLong("phone")));
		return user;
	}

}
