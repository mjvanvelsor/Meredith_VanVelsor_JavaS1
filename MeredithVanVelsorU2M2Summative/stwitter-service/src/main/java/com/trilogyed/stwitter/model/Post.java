package com.trilogyed.stwitter.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class Post {
    private int postID;
    @NotNull
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate postDate;
    @NotNull
    private String posterName;
    @NotNull
    private String post;

    public Post() {
    }

    public Post(int postID, LocalDate postDate, String posterName, String post) {
        this.postID = postID;
        this.postDate = postDate;
        this.posterName = posterName;
        this.post = post;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post1 = (Post) o;
        return getPostID() == post1.getPostID() &&
                getPostDate().equals(post1.getPostDate()) &&
                getPosterName().equals(post1.getPosterName()) &&
                Objects.equals(getPost(), post1.getPost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostID(), getPostDate(), getPosterName(), getPost());
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", post='" + post + '\'' +
                '}';
    }
}
