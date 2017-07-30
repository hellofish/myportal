package com.wawa.message.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wawa.common.exception.PortalException;
import com.wawa.message.pojo.Message;
import com.wawa.message.service.IMessageService;



@Controller
@RequestMapping("/message")
public class MessageController {
	
	@Resource(name = "mesService")
	private IMessageService ms;
	
	@RequestMapping("/saveM")
	public void saveMessage(Message mes) throws PortalException{
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//Date currentTime = df.format(new Date());
		mes.setmDate(new Date());
		ms.saveMessage(mes);
		System.out.println("hello");
	
	}

}
