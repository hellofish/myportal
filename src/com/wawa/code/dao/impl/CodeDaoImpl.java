package com.wawa.code.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wawa.blog.pojo.Comment;
import com.wawa.code.dao.ICodeDao;
import com.wawa.code.pojo.Code;
import com.wawa.user.pojo.User;

@Repository("codeDao")
public class CodeDaoImpl implements ICodeDao{

	@Autowired
	private JdbcTemplate jdbc;
	@Autowired
	private NamedParameterJdbcTemplate jdbcNamed;
	
	//根据用户得到Code
			public void saveCode(Code code){
				String SAVECODE = "insert into code(code,user_id)"
						+ "values(?,?)";
				 jdbc.update(SAVECODE,
						 new Object[]{code.getCode(),code.getUser().getUserId()});
			}
	
	//根据用户得到Code
			public Code getCode(User user){
				String GETCODE = "select * from user where user_id = ?";
				Code code = new Code();
				code = jdbc.queryForObject(GETCODE, Code.class, user.getUserId());
				return code; 
			}
}
