package com.trilogyed.post.model;

import com.trilogyed.post.dao.PostDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostDaoJdbcTemplateImplTest {

    @Autowired
    PostDao postDao;

    @Before
    public void setUp() throws Exception {
        List<Post> postList = postDao.getAllPosts();
        postList.stream().forEach(post -> postDao.deletePost(post.getPostID()));
    }

    @Test
    public void addGetDeletePost() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 8, 10));
        post.setPosterName("Jackson");
        post.setPost("This is a post about something.");

        postDao.addPost(post);
        assertEquals(post, postDao.getPost(post.getPostID()));
        postDao.deletePost(post.getPostID());
        assertNull(postDao.getPost(post.getPostID()));
    }

    @Test
    public void getAllPostsAndGetByPoster() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 8, 10));
        post.setPosterName("Jackson");
        post.setPost("This is a post about something.");

        postDao.addPost(post);

        Post post1 = new Post();
        post1.setPostDate(LocalDate.of(2019, 8, 10));
        post1.setPosterName("Greyson");
        post1.setPost("This is a post about something else.");

        postDao.addPost(post1);

        List<Post> postList = postDao.getAllPosts();
        assertEquals(postList.size(), 2);
        List<Post> postsByPoster = postDao.getAllPostsByPoster("Jackson");
        assertEquals(1, postsByPoster.size());
    }



    @Test
    public void updatePost() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 8, 10));
        post.setPosterName("Jackson");
        post.setPost("This is a post about something.");

        postDao.addPost(post);

        post.setPosterName("Crystal");

        postDao.updatePost(post);

        assertEquals(post, postDao.getPost(post.getPostID()));
    }

}