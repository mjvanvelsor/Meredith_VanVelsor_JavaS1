package com.trilogyed.comment.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class Comment {

    private int commentId;
    @NotNull(message = "Insert post id.")
    private int postId;
    @NotNull(message = "Insert create date.")
    private LocalDate createDate;
    @NotEmpty(message = "Enter commenter name.")
    private String commenterName;
    @NotEmpty(message = "Enter comment.")
    private String comment;

    public Comment() {
    }

    public Comment(int commentId, int postId, LocalDate createDate, String commenterName, String comment) {
        this.commentId = commentId;
        this.postId = postId;
        this.createDate = createDate;
        this.commenterName = commenterName;
        this.comment = comment;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return commentId == comment1.commentId &&
                postId == comment1.postId &&
                createDate.equals(comment1.createDate) &&
                commenterName.equals(comment1.commenterName) &&
                comment.equals(comment1.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, postId, createDate, commenterName, comment);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", createDate=" + createDate +
                ", commenterName='" + commenterName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
