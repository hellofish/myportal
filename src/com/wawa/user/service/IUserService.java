package com.wawa.user.service;

import com.wawa.user.pojo.User;

public interface IUserService {
	User userLogin(User user);
	
	void saveUser(User user);
	
	public User findUserByCodeid(Integer codeid);
}
