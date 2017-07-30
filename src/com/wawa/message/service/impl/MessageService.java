package com.wawa.message.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wawa.message.dao.IMessageDao;
import com.wawa.message.pojo.Message;
import com.wawa.message.service.IMessageService;

@Service("mesService")
public class MessageService implements IMessageService{

	@Autowired
	private IMessageDao mesDao;
	
	public void saveMessage(Message msg) {
		// TODO Auto-generated method stub
		mesDao.saveMessage(msg);
	}

}
