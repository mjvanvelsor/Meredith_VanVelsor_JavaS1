package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.exception.NotFoundException;
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
    // no caching bc no id is returned.
    @PostMapping
    public void createComment(@RequestBody @Valid Comment comment) {
        System.out.println("CREATING POST");
        service.createComment(comment);
    }

    @Cacheable
    @GetMapping("/{id}")
    public Comment getComment(@PathVariable int id) {
        Comment comment = service.findComment(id);
        if (comment == null)
            throw new NotFoundException("Comment could not be retrieved for given id: " + id);
        System.out.println("GETTING COMMENT ID = " + id);
        return service.findComment(id);
    }

    @GetMapping("/all")
    public List<Comment> getAllComments() {
        List<Comment> comments = service.findAllComments();
        if (comments == null)
            throw new NotFoundException("Comments could not be retrieved.");
        return service.findAllComments();
    }

    @GetMapping("/postId/{postId}")
    public List<Comment> getAllCommentsByPostId(@PathVariable int postId) {
        List<Comment> comments = service.findAllCommentsByPostId(postId);
        if (comments == null)
            throw new NotFoundException("Comments could not be retrieved for: " + postId);

        return service.findAllCommentsByPostId(postId);
    }

    @CacheEvict(key = "#comment.getCommentId()")
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

