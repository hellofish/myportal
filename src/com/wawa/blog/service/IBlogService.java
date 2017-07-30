package com.wawa.blog.service;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.wawa.blog.pojo.BlogTag;
import com.wawa.blog.pojo.BlogTagDic;
import com.wawa.blog.pojo.Category;
import com.wawa.blog.pojo.Comment;
import com.wawa.blog.pojo.Post;
import com.wawa.common.utils.Pagination;

public interface IBlogService {

    Long savePost(Post post) throws DataAccessException;

    Post findPostById(Long id) throws DataAccessException;

    Collection<Post> findAllPost() throws DataAccessException;

    void deleteAllPost() throws DataAccessException;

    void deletePost(Long id) throws DataAccessException;
    
    List<Post> findBlogsWithPage(Pagination page);

    Integer findAmountByDate(int year, int month); 
    
    List<Post> findBlogsWithPageAndYear(Pagination page,Integer year);
    
    List<BlogTagDic> findAllBlogTags();

    Long saveCategory(Category category) throws  DataAccessException;

    Category findCategoryById(Long id) throws  DataAccessException;

    Collection<Category> findAllCategory() throws DataAccessException;

    void deleteCategory(Long id) throws DataAccessException;
    
    public List<Post> findBlogsByTags(Pagination page, List<String> tags );


    void saveComment(Comment comment) throws DataAccessException;

    Comment findCommentById(Long id) throws DataAccessException;

    Collection<Comment> findAllComment() throws DataAccessException;

    Collection<Comment> findCommentByPostId(Long postId) throws DataAccessException;

    void deleteComment(Long id) throws DataAccessException;
    
    public List<BlogTag> findBlogTagsByBlogId(Long blogId);
    
    List<Comment> findCommentsByBlogId(Integer blogid);

}
