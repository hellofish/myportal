package com.wawa.photo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wawa.common.exception.PortalException;

@Controller
@RequestMapping("/photo")
public class PhotoController {
	
	@RequestMapping("/photolist")
	public String getAllPhoto(Model model) throws PortalException{
		return "photo/photolist";
}
}
