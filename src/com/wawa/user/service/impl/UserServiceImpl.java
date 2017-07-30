package com.wawa.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wawa.user.dao.IUserDao;
import com.wawa.user.pojo.User;
import com.wawa.user.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource(name="userDao")
	private IUserDao userDao;
	
	public User userLogin(User user) {
		// TODO Auto-generated method stub
		User dbUser = userDao.findUserByName(user.getUserLoginName());

		if (dbUser != null
				&& (dbUser.getUserPassword().equals(user.getUserPassword()))) {
			return dbUser;
		}

		return null;
	}
	
	public void saveUser(User user){
		userDao.saveUser(user);
	}
	
	public User findUserByCodeid(Integer codeid){
		return userDao.findUserByCodeID(codeid);
	}

}
