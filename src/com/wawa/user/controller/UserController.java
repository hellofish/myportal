package com.wawa.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wawa.user.pojo.User;
import com.wawa.user.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name = "userService")
	private IUserService userService;

	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request) {
		
		User loginUser = userService.userLogin(user);
		if (loginUser != null) {
			if (loginUser.getUserType().equals("2")) {
				return "portals/portal";
			} else {
				request.getSession().setAttribute("User", loginUser);
				return "main";
			}
		}
		return "redirect:/commons/error";
	}
}
