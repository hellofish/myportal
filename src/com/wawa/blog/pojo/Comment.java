package com.wawa.blog.pojo;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable{
	private Long commentId;
	private Long postId;
	private String commentAuthor;
	 private String commentAuthorEmail;
	 private Date commentDate;
	 private String commentContent;
	 private Long commentParent;
	 private Long userId;
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public String getCommentAuthor() {
		return commentAuthor;
	}
	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}
	public String getCommentAuthorEmail() {
		return commentAuthorEmail;
	}
	public void setCommentAuthorEmail(String commentAuthorEmail) {
		this.commentAuthorEmail = commentAuthorEmail;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Long getCommentParent() {
		return commentParent;
	}
	public void setCommentParent(Long commentParent) {
		this.commentParent = commentParent;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
