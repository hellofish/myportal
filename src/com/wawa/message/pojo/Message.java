package com.wawa.message.pojo;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer messageID;
	private String clientName;
	private String clientPhone;
	private String message;
	private Date mDate;
	
	public Integer getMessageID() {
		return messageID;
	}
	public void setMessageID(Integer messageID) {
		this.messageID = messageID;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientPhone() {
		return clientPhone;
	}
	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getmDate() {
		return mDate;
	}
	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}

}
