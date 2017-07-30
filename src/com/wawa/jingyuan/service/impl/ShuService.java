package com.wawa.jingyuan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wawa.jingyuan.dao.IShuDao;
import com.wawa.jingyuan.pojo.ShuPhoto;
import com.wawa.jingyuan.service.IShuService;

@Service("shuService")
public class ShuService implements IShuService{
	
	@Autowired
	private IShuDao shuDao;
	
	public List<ShuPhoto> getPhotos(String year, String month, Integer type){
		List<ShuPhoto> photos = new ArrayList();
		photos = shuDao.findShowPhotoByDate(year, month, type);
		return photos;
	}

}
