package com.trilogyed.stwitter.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PostWithComments extends Post{

    private List<Comment> comments;

    public PostWithComments() {
    }

    public PostWithComments( List<Comment> comments) {
        this.comments = comments;
    }

    public PostWithComments(int postID, LocalDate postDate, String posterName, String post, List<Comment> comments) {
        super(postID, postDate, posterName, post);
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PostWithComments that = (PostWithComments) o;
        return getComments().equals(that.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getComments());
    }

    @Override
    public String toString() {
        return "PostWithComments{" +
                "comments=" + comments +
                '}';
    }
}
