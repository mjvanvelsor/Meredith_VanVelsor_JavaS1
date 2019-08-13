package com.trilogyed.stwitter.util.feign;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@FeignClient(name = "comment-service")
public interface CommentServiceClient {

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public Comment createComment(@RequestBody @Valid Comment comment);

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    public Comment findComment(@PathVariable int id);

    @RequestMapping(value = "/comments/all", method = RequestMethod.GET)
    public List<Comment> findAllComments();

    @RequestMapping(value = "/comments/{postid}", method = RequestMethod.GET)
    public List<Comment> findAllCommentsByPostId(int postid);

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.PUT)
    public void updateComment(@PathVariable("id") @RequestBody Comment comment);

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable int id);
}
