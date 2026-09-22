package com.lms.app.model;

import java.sql.Timestamp;

public class Comment {

    private int commentId;
    private int userId;
    private int postId;
    private Integer parentCommentId;
    private String commentText;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Comment(int commentId, int userId, int postId, Integer parentCommentId, String commentText, Timestamp createdAt, Timestamp updatedAt) {
        this.commentId = commentId;
        this.userId = userId;
        this.postId = postId;
        this.parentCommentId = parentCommentId;
        this.commentText = commentText;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", postId=" + postId +
                ", parentCommentId=" + parentCommentId +
                ", commentText='" + commentText + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}