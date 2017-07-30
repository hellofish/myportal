package com.wawa.jingyuan.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wawa.blog.pojo.Comment;
import com.wawa.blog.pojo.Post;
import com.wawa.jingyuan.dao.IShuDao;
import com.wawa.jingyuan.pojo.ShuPhoto;


@Repository("shuDao")
public class ShuDao implements IShuDao{
	
	@Autowired
	private JdbcTemplate jdbc;
	@Autowired
	private NamedParameterJdbcTemplate jdbcNamed;
	
	public List<ShuPhoto> findShowPhotoByDate(String year, String month,Integer type ){
		String sql = "select * from shuphoto where year = ? and month = ? and type = ?";
		List<ShuPhoto> photos = jdbc.query(sql, new Object[]{year,month,type}, new RowMapper<ShuPhoto>(){
			public ShuPhoto mapRow(ResultSet rs, int rowNum) throws SQLException{
				ShuPhoto photo = new ShuPhoto();
				photo.setYear(rs.getString("year"));
				photo.setMonth(rs.getString("month"));
				photo.setPath(rs.getString("path"));
				photo.setType(rs.getInt("type"));
				return photo;
			}
		});
		return photos;
	}

}
