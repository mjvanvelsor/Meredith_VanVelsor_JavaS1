package com.example.commentqueueconsumer.util.feign;

import com.example.commentqueueconsumer.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comments")
@FeignClient(name = "comment-service")
public interface CommentServiceClient {

    @PutMapping("/{id}")
    public void updateComment(@PathVariable int id, @RequestBody Comment comment);

    @PostMapping
    public Comment addComment(@RequestBody Comment comment);

}
