package com.trilogyed.comment.controller;

import com.trilogyed.comment.model.Comment;
import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comments")
@RefreshScope
public class CommentController {

    @Autowired
    CommentDao dao;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment createComment(@RequestBody @Valid Comment comment){
        return dao.addComment(comment);
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Comment findComment(@PathVariable int id){
        Comment comment = dao.getComment(id);
        if (comment == null)
            throw new NotFoundException("Comment could not be retrieved for the given id: " + id);
        return comment;
    }

    @GetMapping("/all")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> findAllComments(){
        List<Comment> comments = dao.getAllComments();
        return comments;
    }

    @GetMapping("/postId/{postId}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Comment> findAllCommentsByPostId(@PathVariable int postId){
        List<Comment> comments = dao.getAllCommentsByPostId(postId);
        return comments;
    }


    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable int id, @RequestBody @Valid Comment comment){
        if (comment.getCommentId() == 0)
            comment.setCommentId(id);
        if (id != comment.getCommentId()) {
            throw new IllegalArgumentException(
                    "Comment id on path must match the id in the Comment object."
            );
        }
        dao.updateComment(comment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable int id){
        dao.deleteComment(id);
    }
}
