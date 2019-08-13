package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.exception.NotFoundException;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.model.PostWithComments;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    PostServiceClient postClient;
    CommentServiceClient commentClient;
    private RabbitTemplate rabbitTemplate;

    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "comment.create.#";

    @Autowired
    public ServiceLayer(PostServiceClient postClient,
                        CommentServiceClient commentClient,
                        RabbitTemplate rabbitTemplate) {
        this.postClient = postClient;
        this.commentClient = commentClient;
        this.rabbitTemplate = rabbitTemplate;
    }
    // Post API
    @Transactional
    public PostWithComments createPost(Post post) {
        post = postClient.createPost(post);
        post.setPostID(post.getPostID());
        return buildPostWithComments(post);
    }
    public PostWithComments findPost(int id) {
        Post post = postClient.findPost(id);
        if (post == null)
            return null;
        else
        return buildPostWithComments(post);
    }
    public List<PostWithComments> findAllPosts() {
        List<PostWithComments> posts = new ArrayList<>();
        List<Post> postList = postClient.findAllPosts();
        postList.stream().forEach(post -> posts.add(buildPostWithComments(post)));
        return posts;
    }
    public List<PostWithComments> findAllPostsByPoster(String name) {
        List<PostWithComments> posts = new ArrayList<>();
        List<Post> postList = postClient.findAllPostsByPoster(name);
        postList.stream().forEach(post -> posts.add(buildPostWithComments(post)));
        return posts;
    }
    @Transactional
    public void updatePost(PostWithComments pwc) {
        Post post = new Post();
        post.setPostID(pwc.getPostID());
        post.setPostDate(pwc.getPostDate());
        post.setPosterName(pwc.getPosterName());
        post.setPost(pwc.getPost());
        postClient.updatePost(post);

        List<Comment> comments = pwc.getComments();//commentClient.findAllCommentsByPostId(pwc.getPostID());
        comments.stream().forEach(comment ->
        {
            comment.setPostId(pwc.getPostID());

            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, comment);
        });
    }
    public void deletePost(int id) {
        postClient.deletePost(id);
    }

    //Comment API
    @Transactional
    public void createComment(Comment comment) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, comment);
        System.out.println("Comment is being created.");
    }
    public Comment findComment(int id) {
        Comment comment = commentClient.findComment(id);
        if (comment == null)
            return null;
        else
            return comment;
    }
    public List<Comment> findAllComments() {
        List<Comment> comments = commentClient.findAllComments();
        return comments;
    }
    public List<Comment> findAllCommentsByPostId(int postId) {
        List<Comment> comments = commentClient.findAllCommentsByPostId(postId);
        return comments;
    }
    @Transactional
    public void updateComment(Comment comment) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, comment);
        System.out.println("Comment is being updated.");
    }
    public void deleteComment(int id) {
        commentClient.deleteComment(id);
    }

    // Helper Methods
    private PostWithComments buildPostWithComments(Post post) {
        PostWithComments pwc = new PostWithComments();
        pwc.setPostID(post.getPostID());
        pwc.setPostDate(post.getPostDate());
        pwc.setPosterName(post.getPosterName());
        pwc.setPost(post.getPost());

        try {
            List<Comment> comments = commentClient.findAllCommentsByPostId(post.getPostID());
            pwc.setComments(comments);
        } catch (Exception e) {
            if (e.getCause().getClass().equals(SocketTimeoutException.class)) {
                throw new NotFoundException("Server connection timeout!");
            } else {
                throw e;
            }
        }
        return pwc;
    }
}


