package com.lms.app.model;

import java.sql.Timestamp;

public class Post {

    private int postId;
    private int userId;
    private String caption;
    private String imageUrl;
    private String status;
    private Timestamp createdAt;

    public Post(int postId, int userId, String caption, String imageUrl, String status, Timestamp createdAt) {
        this.postId = postId;
        this.userId = userId;
        this.caption = caption;
        this.imageUrl = imageUrl;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", caption='" + caption + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}