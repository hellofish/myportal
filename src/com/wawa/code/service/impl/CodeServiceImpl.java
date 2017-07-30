package com.wawa.code.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wawa.code.dao.ICodeDao;
import com.wawa.code.pojo.Code;
import com.wawa.code.service.ICodeService;
import com.wawa.user.dao.IUserDao;
import com.wawa.user.pojo.User;

@Service("codeService")
public class CodeServiceImpl implements ICodeService{
	
	@Autowired
	private ICodeDao codeDao;
	
	@Autowired
	private IUserDao uDao;
	
	public void saveCode(Code code){
		codeDao.saveCode(code);
	}
	
	
	public Code getCode(User user){
		return codeDao.getCode(user);
	}
	
	public void applyCode(Code code){
		//code.setUser(uDao.findUserByCodeID(code.getCodeID()));
		//uDao.saveUser(code.getUser());
		//User dbuser = uDao.findUserByPhone(code.getUser().getClientPhone());
		User dbuser = uDao.saveAndGetUser(code.getUser());
		code.getUser().setUserId(dbuser.getUserId());
		codeDao.saveCode(code);
		Code dbcode = codeDao.getCode(dbuser);
		uDao.updateUserForCode(dbcode.getUser());
		//uDao.updateUserForCode();
		
		
		
	}
	
	
}
