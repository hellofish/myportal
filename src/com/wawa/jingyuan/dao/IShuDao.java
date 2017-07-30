package com.wawa.jingyuan.dao;

import java.util.List;

import com.wawa.jingyuan.pojo.ShuPhoto;

public interface IShuDao {

	public List<ShuPhoto> findShowPhotoByDate(String year, String month,Integer type );
}
