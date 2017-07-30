package com.wawa.message.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wawa.message.dao.IMessageDao;
import com.wawa.message.pojo.Message;

@Repository("mesDao")
public class MessageDao implements IMessageDao{

	@Autowired
	private JdbcTemplate jdbc;
	
	public void saveMessage(Message mes) {
		// TODO Auto-generated method stub
		jdbc.update("insert into message(client_name,client_phone,message,m_date) values(?,?,?,?)",   
                new Object[]{mes.getClientName(),mes.getClientPhone(),mes.getMessage(),mes.getmDate()});
	}
	
	

}
