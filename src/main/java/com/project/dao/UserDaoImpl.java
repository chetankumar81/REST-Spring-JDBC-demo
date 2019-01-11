package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.project.model.User;
import com.project.model.UserMapper;

@Repository
public class UserDaoImpl implements UserDAO {

	private final String SQL_GET_ALL = "select * from  \"User\"";
	private final String SQL_ADD_USER = "insert into \"User\" (email_id,password,phone) values (?,?,?)";
	private final String SQL_GET_USER_BY_ID = "select * from \"User\" where \"Id\" = ?";
	private final String SQL_UPDATE_USER = "update \"User\" set email_id =?,password = ?, phone = ? where \"Id\" = ?";
	private final String SQL_DELETE_USER_BY_ID = "delete from \"User\" where \"Id\" = ?";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> getAllUsers() {
		List<User>  list = jdbcTemplate.query(SQL_GET_ALL, new UserMapper());
		return list;
	}
	
	@Override
	public User getUserById(String userId) {
		User user = jdbcTemplate.queryForObject(SQL_GET_USER_BY_ID,new UserMapper(), Integer.parseInt(userId));
		return user;
	}

	@Override
	public int deleteUser(String userId) {
		return jdbcTemplate.update(SQL_DELETE_USER_BY_ID,Integer.parseInt(userId));
	}

	@Override
	public User addUser(final User user) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(SQL_ADD_USER,new String[] {"Id"});
				ps.setString(1, user.getEmailId());
				ps.setString(2, user.getPassword());
				ps.setLong(3, Long.parseLong(user.getPhone()));
				return ps;
			}
		},keyHolder);
		
		return getUserById(keyHolder.getKey().toString());
		//jdbcTemplate.update(SQL_ADD_USER,user.getEmailId(),user.getPassword(),Long.parseLong(user.getPhone()));	
	}

	@Override
	public User updateUser(User user) {
		jdbcTemplate.update(SQL_UPDATE_USER,user.getEmailId(),user.getPassword(),Long.parseLong(user.getPhone()),Integer.parseInt(user.getUserId()));
		return user;
	}
}
