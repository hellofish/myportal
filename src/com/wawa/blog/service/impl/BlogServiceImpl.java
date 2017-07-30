package com.wawa.blog.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.wawa.blog.dao.IBlogDao;
import com.wawa.blog.pojo.BlogTag;
import com.wawa.blog.pojo.BlogTagDic;
import com.wawa.blog.pojo.Category;
import com.wawa.blog.pojo.Comment;
import com.wawa.blog.pojo.Post;
import com.wawa.blog.service.IBlogService;
import com.wawa.common.utils.Pagination;

@Service("blogService")
public class BlogServiceImpl implements IBlogService{
	
	@Autowired
	private IBlogDao blogDao;

	@Override
	public Long savePost(Post post) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post findPostById(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Post> findAllPost() throws DataAccessException {
		// TODO Auto-generated method stub
		Collection<Post> posts = blogDao.findAll();
		return posts;
	}

	@Override
	public void deleteAllPost() throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePost(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long saveCategory(Category category) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findCategoryById(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Category> findAllCategory() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void saveComment(Comment comment) throws DataAccessException {
		blogDao.saveComment(comment);
	}

	@Override
	public Comment findCommentById(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Comment> findAllComment() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Comment> findCommentByPostId(Long postId)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComment(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public List<Post> findBlogsWithPage(Pagination page) {
		// TODO Auto-generated method stub
		List<Post> blogs = new ArrayList<Post>();
		
		blogs = blogDao.findBlogsByPage(page.getFirstResult(), page.getMaxResult());
		
		for(Post blog : blogs){
			blog.setTags(blogDao.findBlogTagsByBlogId(blog.getPostId()));
		}
		return blogs;
	}

	public Integer findAmountByDate(int year,int month) {
		// TODO Auto-generated method stub
		return blogDao.findBlogsByDate(year, month);
	}

	public List<Post> findBlogsWithPageAndYear(Pagination page, Integer year) {
		// TODO Auto-generated method stub
		List<Post> blogs = new ArrayList<Post>();
		blogs =  blogDao.findBlogsByPageAndYear(page.getFirstResult(), page.getMaxResult(),year);
		for(Post blog : blogs){
			blog.setTags(blogDao.findBlogTagsByBlogId(blog.getPostId()));
		}
		return blogs;
	}
	
	public List<Post> findBlogsByTags(Pagination page, List<String> tags ){
		List<Post> blogs = new ArrayList<Post>();
		blogs =  blogDao.findBlogsByTags(page.getFirstResult(), page.getMaxResult(),tags);
		for(Post blog : blogs){
			blog.setTags(blogDao.findBlogTagsByBlogId(blog.getPostId()));
		}
		return blogs;
	}


	public List<BlogTagDic> findAllBlogTags() {
		return blogDao.fingBlogTags();
	}
	
	public List<BlogTag> findBlogTagsByBlogId(Long blogId){
		return blogDao.findBlogTagsByBlogId(blogId);
	}
	
	public List<Comment> findCommentsByBlogId(Integer blogId){
		return blogDao.findCommentsByBlogId(blogId);
	}
	

}
