package com.wawa.code.controller;

import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.wawa.code.pojo.Code;
import com.wawa.code.service.ICodeService;

@Controller
@RequestMapping("/code")
public class CodeController {
	
	@Resource(name = "codeService")
	private ICodeService cs;
	
	
	@RequestMapping("/getcode")
	public @ResponseBody String getCode(Code code, HttpServletRequest request){
		 HttpSession hs = request.getSession();
		 if(code.getJzrPhone().equals("18611172811")){
			 int pcode =  produceCode(Integer.parseInt(code.getUser().getClientPhone().substring(6, 11)));
			 code.setCode(Integer.toString(pcode));
			 //cs.applyCode(code);
			 hs.setAttribute("user", code.getUser());
			 
			 return JSON.toJSONString(code);
		 }
		 
		return JSON.toJSONString("您输入的信息有误，请核对后再次提交");
		
	}
	
	@RequestMapping("/vcode")
	public String validateCode(){
		return "sucess";
	}
	
	
	private int produceCode(int phone){
		Random rand= new Random(); 
		int max = (int) 99999999999L;
		int tmp = Math.abs(rand.nextInt());
	    return tmp % (max - phone + 1) + phone;
	}
}
