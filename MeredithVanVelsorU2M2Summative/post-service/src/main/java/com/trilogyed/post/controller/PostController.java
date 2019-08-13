package com.trilogyed.post.controller;

import com.trilogyed.post.exception.NotFoundException;
import com.trilogyed.post.model.Post;
import com.trilogyed.post.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RefreshScope
public class PostController {
    @Autowired
    PostDao dao;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        return dao.addPost(post);
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Post findPost(@PathVariable int id) {
        Post post = dao.getPost(id);
        if (post == null)
            throw new NotFoundException("Post could not be retrieved for the given id: " + id);
        return post;
    }

    @GetMapping("/all")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Post> findAllPosts() {
        List<Post> posts = dao.getAllPosts();
        return posts;
    }

    @GetMapping("/user/{posterName}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Post> findAllPostsByPoster(String name){
        List<Post> postList = dao.getAllPostsByPoster(name);
        return postList;
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable int id, @RequestBody Post post) {
        if (post.getPostID() == 0)
            post.setPostID(id);
        if (id != post.getPostID()){
            throw new IllegalArgumentException(
                    "Post id on path must match the id in the Post object."
            );
        }
        dao.updatePost(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id) {
        dao.deletePost(id);
    }
}
