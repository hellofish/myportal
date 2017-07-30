package com.wawa.user.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wawa.user.dao.IUserDao;
import com.wawa.user.pojo.User;

@Repository("userDao")
public class UserDao implements IUserDao{
	
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public User findUserByName(final String userName) {
		// TODO Auto-generated method stub
		String sql = " SELECT user_id,user_name,password,user_type "
		        + " FROM user WHERE user_name =? ";
		    final User user = new User();
		    jdbc.query(sql, new Object[] { userName },
		        new RowCallbackHandler() {
		          public void processRow(ResultSet rs) throws SQLException {
		            user.setUserId(rs.getInt("user_id"));
		            user.setUserLoginName(userName);
		            user.setUserPassword(rs.getString("password"));
		            user.setUserType(rs.getString("user_type"));
		          }
		        });
		return user;
	}
	
	public User findUserByOthers(String name, String password){
		String sql =" SELECT * FROM user WHERE user_name =? and password = ?";
		User user = new User();
		user.setUserLoginName(name);
		user.setUserPassword(password);
		Map<String, Object> dbuser = jdbc.queryForMap(sql,user.getUserLoginName(),user.getUserPassword() );
		
		return null;
	}
	
	
	public void saveUser(User user){
		String sql = "insert into user(clientphone,user_truename,email) values(?,?,?)";
		jdbc.update(sql,
				 new Object[]{user.getClientPhone(),user.getUserTrueName(),user.geteMail()});
	}
	
	public User saveAndGetUser(User user){
		String sql = "insert into user(clientphone,user_truename,email) values(?,?,?)";
		jdbc.update(sql,
				 new Object[]{user.getClientPhone(),user.getUserTrueName(),user.geteMail()});
		
		String sql2 = "select * from user where clientphone = ?";
		User dbuser = jdbc.queryForObject(sql, User.class,user.getClientPhone());
		return user;
	}
	
	public User findUserByCodeID(Integer codeid){
		String sql = "select * from user where user_codeid = ?";
		User user = jdbc.queryForObject(sql, User.class, codeid);
		return user;
	}
	
	public User findUserByPhone(String phone){
		String sql = "select * from user where clientphone = ?";
		User user = jdbc.queryForObject(sql, User.class,phone);
		return user;
	}
	
	public void updateUserForCode(User user){
		String sql = "update user set code_id = ? where user_id = ?";
		jdbc.update(sql,
				 new Object[]{user.getCode().getCodeID(),user.getUserId()});
	}

}
