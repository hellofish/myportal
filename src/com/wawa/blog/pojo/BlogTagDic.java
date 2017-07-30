package com.wawa.blog.pojo;

import java.io.Serializable;

public class BlogTagDic implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer tagId;
	private Integer blogTagCode;
	private String blogTagName;
	private String tagStyle;
	
	public Integer getBlogTagCode() {
		return blogTagCode;
	}
	public void setBlogTagCode(Integer blogTagCode) {
		this.blogTagCode = blogTagCode;
	}
	public String getBlogTagName() {
		return blogTagName;
	}
	public void setBlogTagName(String blogTagName) {
		this.blogTagName = blogTagName;
	}
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public String getTagStyle() {
		return tagStyle;
	}
	public void setTagStyle(String tagStyle) {
		this.tagStyle = tagStyle;
	}
	
	
	

}
