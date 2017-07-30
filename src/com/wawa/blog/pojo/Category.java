package com.wawa.blog.pojo;

import java.io.Serializable;

public class Category implements Serializable{
	
	 private Long catId;
	 private String catName;
	 private String catDescription;
	 private Long catParent;
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatDescription() {
		return catDescription;
	}
	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}
	public Long getCatParent() {
		return catParent;
	}
	public void setCatParent(Long catParent) {
		this.catParent = catParent;
	}

}
