package com.wawa.blog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.wawa.blog.pojo.BlogTagDic;
import com.wawa.blog.pojo.Comment;
import com.wawa.blog.pojo.Post;
import com.wawa.blog.service.IBlogService;
import com.wawa.common.exception.PortalException;
import com.wawa.common.utils.Pagination;
import com.wawa.user.pojo.User;


@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Resource(name = "blogService")
	private IBlogService bs;
	
	private List<Integer> years;
	private List<Map> contents;
	private List<BlogTagDic> tags;
	
	@RequestMapping("/bloglist")
	public String getAllBlogs(Model model) throws PortalException{
		//<Post> blogs = bs.findAllPost();
		Pagination page = new Pagination(1);
		List<Post> blogs = bs.findBlogsWithPage(page);
		
		tags = bs.findAllBlogTags();
		contents = getYearsAmount(2015);
		years = setYears();
		model.addAttribute("blogs", blogs);
		model.addAttribute("amounts", contents);
		model.addAttribute("years", years);
		model.addAttribute("tags",tags);
		return "blog/blog";
	}
	

	@RequestMapping("/bloglist/{pageNum}/{year}")
	public @ResponseBody String blogList(@PathVariable Integer pageNum,@PathVariable Integer year,@RequestParam("tags[]") List<String> tagValues,Model model) throws PortalException{
		
		Pagination page = new Pagination(pageNum);
		List<Post> blogs;
		//List<Integer> bTags = new ArrayList<Integer>();
		if(!tagValues.get(0).equals("8888")){
			blogs = bs.findBlogsByTags(page, tagValues);
		}else{
			blogs = bs.findBlogsWithPageAndYear(page,year);
		}
		
		contents = getYearsAmount(year);
		List jsonList = new ArrayList();
		jsonList.add(0,blogs);
		jsonList.add(1,contents);
		return JSONArray.toJSONString(jsonList);
	}
	
	//通过blogID获得评论
	@RequestMapping("/blogcomments/{blogid}")
	public @ResponseBody String comments(@PathVariable Integer blogid){
		List<Comment> coms;
		coms = bs.findCommentsByBlogId(blogid);
		return JSONArray.toJSONString(coms);
	}
	
	//保存评论
	@RequestMapping("/savecomment/{blogid}/{content}")
	public @ResponseBody String saveComment(@PathVariable Long blogid,@PathVariable String content,HttpServletRequest request){
		Comment comt = new Comment();
		comt.setPostId(blogid);
		comt.setCommentContent(content);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		comt.setCommentDate(new Date());
		if(user != null){
			
		}else{
			comt.setCommentAuthor("匿名用户");
			comt.setCommentAuthorEmail("8888@email.com");
			comt.setUserId(Long.parseLong("8888"));
		}
		bs.saveComment(comt);
		//coms = bs.findCommentsByBlogId(blogid);
		return "success";
	}
	
	private List<Map> getYearsAmount(Integer year){
		List<Map> contents = new ArrayList<Map>();
		for(int i=1; i<=12; i++){
			Integer amount = bs.findAmountByDate(year, i);
			Map content = new HashMap<String,Integer>();
			content.put("month", i);
			content.put("num", amount);
			//contents.add("key", amount);
			//contents.add(index, element);
			contents.add(content);
		}
		return contents;
	}
	
	private List<Integer> setYears(){
		List<Integer> years = new ArrayList<Integer>();
		for(int i=0; i<8; i++){
			years.add(2008+i);
		}
		return years;
	}
}
