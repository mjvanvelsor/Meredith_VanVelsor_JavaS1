package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.model.PostWithComments;
import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comments")
@CacheConfig(cacheNames = {"comments"})
public class StwitterCommentController {

    @Autowired
    ServiceLayer service;

    public StwitterCommentController(ServiceLayer service) {
        this.service = service;
    }

    @CachePut(key = "#result.getId()")
    @PostMapping
    public void createComment(@RequestBody @Valid Comment comment) {
        System.out.println("CREATING POST");
        service.createComment(comment);
    }

    @Cacheable
    @GetMapping("/{id}")
    public Comment getComment(@PathVariable int id) {
        System.out.println("GETTING COMMENT ID = " + id);
        return service.findComment(id);
    }

    @GetMapping("/all")
    public List<Comment> getAllComments() {
        return service.findAllComments();
    }

    @GetMapping("/postid/{postId}")
    public List<Comment> getAllCommentsByPostId(@PathVariable int postId) {
        return service.findAllCommentsByPostId(postId);
    }

    @CacheEvict(key = "#comment.getId()")
    @PutMapping("/{id}")
    public void updateComment(@PathVariable @Valid int id, @RequestBody Comment comment) {
        System.out.println("UPDATING COMMENT ID = " + comment.getCommentId());
        if (comment.getCommentId() == 0)
            comment.setCommentId(id);
        if (id != comment.getCommentId()) {
            throw new IllegalArgumentException(
                    "Comment Id on path must match the ID in the Comment object"
            );
        }
        service.updateComment(comment);
    }

    @CacheEvict
    @DeleteMapping
    public void deleteComment(@PathVariable int id) {
        System.out.println("DELETING COMMENT ID = " + id);
        service.deleteComment(id);
    }
}

