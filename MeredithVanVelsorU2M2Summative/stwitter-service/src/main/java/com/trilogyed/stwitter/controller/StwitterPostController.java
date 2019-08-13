package com.trilogyed.stwitter.controller;

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
@RequestMapping("/posts")
@CacheConfig(cacheNames = {"posts"})
public class StwitterPostController {

    @Autowired
    ServiceLayer service;
//    @Autowired
//    CommentServiceClient client;

    public StwitterPostController(ServiceLayer service, CommentServiceClient client) {
        this.service = service;
//        this.client = client;
    }

    @CachePut(key = "#result.getId()")
    @PostMapping
    public PostWithComments createPost(@RequestBody @Valid Post post){
        System.out.println("CREATING POST");
        return service.createPost(post);
    }

    @Cacheable
    @GetMapping("/{id}")
    public PostWithComments getPost(@PathVariable int id){
        System.out.println("GETTING POST ID = " + id);
        return service.findPost(id);
    }

    @GetMapping("/all")
    public List<PostWithComments> getAllPosts(){
        return service.findAllPosts();
    }

    @GetMapping("/user/{posterName}")
    public List<PostWithComments> getAllPostsByPoster(@PathVariable String posterName){
        return service.findAllPostsByPoster(posterName);
    }

    @CacheEvict(key = "#post.getId()")
    @PutMapping("/{id}")
    public void updatePost (@PathVariable @Valid int id, @RequestBody PostWithComments pwc){
        System.out.println("UPDATING POST ID = " + pwc.getPostID());
        if (pwc.getPostID() == 0)
            pwc.setPostID(id);
        if (id != pwc.getPostID()){
            throw new IllegalArgumentException(
                    "Post Id on path must match the ID in the Post object"
            );
        }
        service.updatePost(pwc);
    }

    @CacheEvict
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id){
        System.out.println("DELETING POST ID = " + id);
        service.deletePost(id);
    }

}
