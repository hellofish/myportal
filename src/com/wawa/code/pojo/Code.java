package com.wawa.code.pojo;

import java.io.Serializable;

import com.wawa.user.pojo.User;

public class Code implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2656652778167371720L;
	
	private Integer codeID;
	private String code;
	private User user;
	private String jzrPhone;
	public Integer getCodeID() {
		return codeID;
	}
	public void setCodeID(Integer codeID) {
		this.codeID = codeID;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getJzrPhone() {
		return jzrPhone;
	}
	public void setJzrPhone(String jzrPhone) {
		this.jzrPhone = jzrPhone;
	}
}
