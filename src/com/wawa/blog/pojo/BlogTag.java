package com.wawa.blog.pojo;

import java.io.Serializable;

public class BlogTag implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long blogId;
	private Integer tagId;
	private Integer blogTagCode;
	private String blogTagName;
	private String tagStyle;
	
	public Long getBlogId() {
		return blogId;
	}
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
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
	public String getTagStyle() {
		return tagStyle;
	}
	public void setTagStyle(String tagStyle) {
		this.tagStyle = tagStyle;
	}
	
	

}
