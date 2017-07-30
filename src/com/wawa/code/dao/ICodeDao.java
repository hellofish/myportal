package com.wawa.code.dao;

import com.wawa.code.pojo.Code;
import com.wawa.user.pojo.User;

public interface ICodeDao {

	public Code getCode(User user);
	public void saveCode(Code code);
}
