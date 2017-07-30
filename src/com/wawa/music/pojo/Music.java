package com.wawa.music.pojo;

import java.io.Serializable;

public class Music implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4715734159425530139L;
	private Integer musicID;
	private String musicName;
	private String musicURL;
	public Integer getMusicID() {
		return musicID;
	}
	public void setMusicID(Integer musicID) {
		this.musicID = musicID;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getMusicURL() {
		return musicURL;
	}
	public void setMusicURL(String musicURL) {
		this.musicURL = musicURL;
	}
}
