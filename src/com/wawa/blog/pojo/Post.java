package com.wawa.blog.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wawa.common.utils.TransferDateTimeForJson;

public class Post implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long postId;
	private Long authorId;
	private Date postDate;
	private String postContent;
	private String postTitle;
	private Integer postStatus;
	private Integer commentStatus;
	private Long categoryId;
	private Date postModifiedDate;
	private Integer commentCount;
	private List<BlogTag> tags;
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	//@JsonSerialize(using = TransferDateTimeForJson.class)
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") 
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public Integer getPostStatus() {
		return postStatus;
	}
	public void setPostStatus(Integer postStatus) {
		this.postStatus = postStatus;
	}
	public Integer getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(Integer commentStatus) {
		this.commentStatus = commentStatus;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Date getPostModifiedDate() {
		return postModifiedDate;
	}
	public void setPostModifiedDate(Date postModifiedDate) {
		this.postModifiedDate = postModifiedDate;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public List<BlogTag> getTags() {
		return tags;
	}
	public void setTags(List<BlogTag> tags) {
		this.tags = tags;
	}
}
