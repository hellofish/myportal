package com.wawa.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wawa.blog.dao.IBlogDao;
import com.wawa.blog.pojo.BlogTag;
import com.wawa.blog.pojo.BlogTagDic;
import com.wawa.blog.pojo.Comment;
import com.wawa.blog.pojo.Post;

@Repository("blogDao")
public class BlogDaoImpl implements IBlogDao{
	@Autowired
	private JdbcTemplate jdbc;
	@Autowired
	private NamedParameterJdbcTemplate jdbcNamed;
	
	public Long save(Post post) throws DataAccessException {
		// TODO Auto-generated method stub
		//jdbcNamed.query(sql, paramMap, rowMapper)
		return null;
	}

	public Post find(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Post> findAll() throws DataAccessException { 
		        // TODO Auto-generated method stub  
		     String FINDALL = "select * from post";  
			 Collection<Post> posts = jdbc.query(FINDALL,new BeanPropertyRowMapper<Post>(Post.class));  
		     return posts; 
	}

	@Override
	public void delete(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	
	public List<Post> findBlogsByPage(int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		String FINDBLOGSBYPAGE = "select * from post limit ?,? ";
		List<Post> blogs = jdbc.query(FINDBLOGSBYPAGE, new Object[]{firstResult,maxResult}, new RowMapper<Post>(){
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Post blog = new Post();
				blog.setPostTitle(rs.getString("post_title"));
				blog.setPostContent(rs.getString("post_content"));
				blog.setPostDate(rs.getDate("post_date"));
				blog.setPostId(rs.getLong("post_id"));
				return blog;
			}
		});
		return blogs;
	}
	
	
	//一组标签查找Blog
	public List<Post> findBlogsByTags(Integer firstResult, Integer maxResult, List<String> tags ){
		String FINDBLOGSBYTAGS = "select p.* from post p, blogtag t where p.post_id = t.blog_id and t.blog_tag_code in (:tags) limit :firstResult,:maxResult";
		MapSqlParameterSource parameters = new MapSqlParameterSource();
	    parameters.addValue("tags", tags);
	    parameters.addValue("firstResult", firstResult);
	    parameters.addValue("maxResult", maxResult);
	    List<Post> blogs = jdbcNamed.query(FINDBLOGSBYTAGS, parameters,new RowMapper<Post>(){
	    	public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Post blog = new Post();
				blog.setPostTitle(rs.getString("post_title"));
				blog.setPostContent(rs.getString("post_content"));
				blog.setPostDate(rs.getDate("post_date"));
				blog.setPostId(rs.getLong("post_id"));
				return blog;
			}
		});
		return blogs;
	    }
		/*List<Post> blogs = jdbc.query(FINDBLOGSBYTAGS, new Object[]{},new RowMapper<Post>(){
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Post blog = new Post();
				blog.setPostTitle(rs.getString("post_title"));
				blog.setPostContent(rs.getString("post_content"));
				blog.setPostDate(rs.getDate("post_date"));
				blog.setPostId(rs.getLong("post_id"));
				return blog;
			}
		});
		return blogs;*/
	
	public Integer findBlogsByDate(int year, int month) {
		// TODO Auto-generated method stub
		String FINDBLOGSBYDate = "select count(*) from post where year(post_date)=? and month(post_date)=?";
		int counts = jdbc.queryForInt
				(FINDBLOGSBYDate,new Object[]{year,month});
		//counts.get(0);
		return counts;
		//return jdbc.queryForInt(FINDBLOGSBYDate, new Object[]{year,month},new BeanPropertyRowMapper(Integer.class)); 
	}

	@Override
	public List<Post> findBlogsByPageAndYear(int firstResult, int maxResult,
			int year) {
		String FINDBLOGSBYPAGE = "select * from post where year(post_date)=? limit ?,? ";
		List<Post> blogs = jdbc.query(FINDBLOGSBYPAGE, new Object[]{year,firstResult,maxResult}, new RowMapper<Post>(){
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Post blog = new Post();
				blog.setPostTitle(rs.getString("post_title"));
				blog.setPostContent(rs.getString("post_content"));
				blog.setPostDate(rs.getDate("post_date"));
				blog.setPostId(rs.getLong("post_id"));
				return blog;
			}
		});
		return blogs;
	}

	//查找所有的标签
	public List<BlogTagDic> fingBlogTags() {
		String FINDBLOGTAGS = "select * from blogtagdic";
		List<BlogTagDic> tags = jdbc.query(FINDBLOGTAGS,new BeanPropertyRowMapper<BlogTagDic>(BlogTagDic.class));  
		return tags;
	}
	
	
	//通过blogID找到该Blog下面的所有标签
	public List<BlogTag> findBlogTagsByBlogId(Long blogId){
		String FINDBLOGTAGSBYBLOG = "select * from blogtag where blog_id=?";
		List<BlogTag> blogtags = jdbc.query(FINDBLOGTAGSBYBLOG, new Object[]{blogId}, new RowMapper<BlogTag>(){
			public BlogTag mapRow(ResultSet rs, int rowNum) throws SQLException {
				BlogTag tag = new BlogTag();
				tag.setTagId(rs.getInt("tag_id"));
				tag.setBlogTagCode(rs.getInt("blog_tag_code"));
				tag.setBlogTagName(rs.getString("blog_tag_name"));
				tag.setTagStyle(rs.getString("tag_style"));
				return tag;
			}
		});
		return blogtags;
	}
	
	//通过blogID找到该blog下面的所有评论
	public List<Comment> findCommentsByBlogId(Integer blogId){
		String FINDCOMMENTSBYBLOGID = "select * from comment where post_id = ?";
		List<Comment> comments = jdbc.query(FINDCOMMENTSBYBLOGID, new Object[]{blogId}, new RowMapper<Comment>(){
			public Comment mapRow(ResultSet rs, int rowNum) throws SQLException{
				Comment comment = new Comment();
				comment.setCommentContent(rs.getString("comment_content"));
				comment.setCommentId(rs.getLong("comment_id"));
				comment.setCommentDate(rs.getDate("comment_date"));
				comment.setCommentAuthor(rs.getString("comment_author"));
				comment.setCommentAuthorEmail(rs.getString("comment_author_email"));
				return comment;
			}
		});
		return comments;
	}

	//通过blogID找到该blog下面的所有评论
		public void saveComment(Comment comt){
			String SAVECOMMENT = "insert into comment(post_id,comment_author,comment_author_email,comment_date,comment_content,user_id)"
					+ "values(?,?,?,?,?,?)";
			 jdbc.update(SAVECOMMENT,
					 new Object[]{comt.getPostId(),comt.getCommentAuthor(),comt.getCommentAuthorEmail(),
					 comt.getCommentDate(),comt.getCommentContent(),comt.getUserId()});
		}
	
}
