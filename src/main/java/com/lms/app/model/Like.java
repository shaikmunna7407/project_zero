package com.lms.app.model;

import java.sql.Timestamp;

public class Like {

    private int likeId;
    private User userId;
    private Post postId;
    private Timestamp likedAt;



    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public int getUserId() {
        return userId.getUserId();
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    public Timestamp getLikedAt() {
        return likedAt;
    }

    public void setLikedAt(Timestamp likedAt) {
        this.likedAt = likedAt;
    }

    @Override
    public String toString() {
        return "Like{" +
                "likeId=" + likeId +
                ", userId=" + userId +
                ", postId=" + postId +
                ", likedAt=" + likedAt +
                '}';
    }
}