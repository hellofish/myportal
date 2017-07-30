package com.wawa.jingyuan.service;

import java.util.List;

import com.wawa.jingyuan.pojo.ShuPhoto;

public interface IShuService {
	public List<ShuPhoto> getPhotos(String year, String month, Integer type);
}
