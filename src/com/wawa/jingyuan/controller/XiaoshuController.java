package com.wawa.jingyuan.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.wawa.common.exception.PortalException;
import com.wawa.jingyuan.pojo.ShuPhoto;
import com.wawa.jingyuan.service.IShuService;



@Controller
@RequestMapping("/xiaoshu")
public class XiaoshuController {
	
	@Resource(name = "shuService")
	private IShuService shuService;
	
	@RequestMapping("/collections")
	public String getAllBlogs(Model model) throws PortalException{

		return "xiaoshu/index";
	}
	
	
	@RequestMapping("/collections/{year}/{mon}")
	public @ResponseBody String getCollectionsByMonth(@PathVariable String year,@PathVariable String mon) throws PortalException{
		Integer type = 2;
		List<ShuPhoto> photos = shuService.getPhotos(year, mon, type);
		
		return JSONArray.toJSONString(photos);
	}
	
	@RequestMapping("/cdetail/{year}/{mon}")
	public @ResponseBody String getDetailByMonth(@PathVariable String year,@PathVariable String mon) throws PortalException{
		Integer type = 1;
		List<ShuPhoto> photos = shuService.getPhotos(year, mon, type);
		
		return JSONArray.toJSONString(photos);
	}

}
