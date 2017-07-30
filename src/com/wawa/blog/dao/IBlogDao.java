package com.wawa.blog.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.wawa.blog.pojo.BlogTag;
import com.wawa.blog.pojo.BlogTagDic;
import com.wawa.blog.pojo.Comment;
import com.wawa.blog.pojo.Post;

public interface IBlogDao {
	
	Long save(Post post) throws DataAccessException;

    Post find(Long id) throws DataAccessException;

    Collection<Post> findAll() throws DataAccessException;

    void delete(Long id) throws DataAccessException;
    
    List<Post> findBlogsByPage(int firstResult,int maxResult);
    
    Integer findBlogsByDate(int year, int month);
    
    List<Post> findBlogsByPageAndYear(int firstResult,int maxResult, int year);
    
    public List<Post> findBlogsByTags(Integer firstResult, Integer maxResult, List<String> tags );
    
    //List<BlogTag> fingBlogTags1();

	List<BlogTagDic> fingBlogTags(); 
	
	public List<BlogTag> findBlogTagsByBlogId(Long blogId);
	
	List<Comment> findCommentsByBlogId(Integer blogId);
	
	public void saveComment(Comment comt);
}
