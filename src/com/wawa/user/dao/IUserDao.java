package com.wawa.user.dao;

import com.wawa.user.pojo.User;


public interface IUserDao {
	User findUserByName(String userName);
	
	void saveUser(User user);
	
	User findUserByCodeID(Integer codeid);
	
	void updateUserForCode(User user);
	User findUserByPhone(String phone);
	
	public User saveAndGetUser(User user);
}
