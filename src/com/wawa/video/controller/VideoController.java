package com.wawa.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wawa.common.exception.PortalException;


@Controller
@RequestMapping("/video")
public class VideoController {
	
	@RequestMapping("/videocollection")
	public String getVideoCollection(Model model) throws PortalException{
		
		return "video/video";
}

}
