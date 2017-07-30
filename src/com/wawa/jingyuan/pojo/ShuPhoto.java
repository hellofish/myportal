package com.wawa.jingyuan.pojo;

import java.io.Serializable;

public class ShuPhoto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer shuPhotoId;
	private String year;
	private String month;
	private String path;
	private Integer type;
	public Integer getShuPhotoId() {
		return shuPhotoId;
	}
	public void setShuPhotoId(Integer shuPhotoId) {
		this.shuPhotoId = shuPhotoId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
	

}
