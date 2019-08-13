package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.exception.NotFoundException;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.model.PostWithComments;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ServiceLayerTest {

    PostServiceClient postClient;
    CommentServiceClient commentClient;
    ServiceLayer serviceLayer;
    RabbitTemplate rabbitTemplate;

    @Before
    public void setUp() throws Exception {
        setUpPostClient();
        setUpCommentClient();
        setUpRabbitTemplate();
        serviceLayer = new ServiceLayer(postClient, commentClient, rabbitTemplate);
    }
    public void setUpPostClient(){
        postClient = mock(PostServiceClient.class);
        Post post = new Post();
        post.setPostID(1);
        post.setPostDate(LocalDate.of(2019, 8, 13));
        post.setPosterName("Fred Weasley");
        post.setPost("Voldemort sucks.");
//        post.setComments(commentClient.findAllCommentsByPostId(1));

        Post post1 = new Post();
        post1.setPostDate(LocalDate.of(2019, 8, 13));
        post1.setPosterName("Fred Weasley");
        post1.setPost("Voldemort sucks.");

        List<Post> posts = new ArrayList<>();
        posts.add(post);

        doReturn(post).when(postClient).createPost(post1);
        doReturn(post).when(postClient).findPost(1);
        doReturn(posts).when(postClient).findAllPosts();
        doReturn(posts).when(postClient).findAllPostsByPoster("Fred Weasley");
    }
    public void setUpCommentClient(){
        commentClient = mock(CommentServiceClient.class);
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 8, 13));
        comment.setCommenterName("George Weasley");
        comment.setComment("Totes agree!");

        Comment comment1 = new Comment();
        comment1.setPostId(1);
        comment1.setCreateDate(LocalDate.of(2019, 8, 13));
        comment1.setCommenterName("George Weasley");
        comment1.setComment("Totes agree!");

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);

        doReturn(comment).when(commentClient).createComment(comment1);
        doReturn(comment).when(commentClient).findComment(1);
        doReturn(comments).when(commentClient).findAllComments();
        doReturn(comments).when(commentClient).findAllCommentsByPostId(1);

    }
    public void setUpRabbitTemplate(){
        rabbitTemplate = mock(RabbitTemplate.class);
        Comment msg = new Comment();
//        doNothing().when(rabbitTemplate).convertAndSend(msg);
    }
    @Test
    public void createFindPostfindAllPostsAndFindAllByPoster() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 8, 13));
        post.setPosterName("Fred Weasley");
        post.setPost("Voldemort sucks.");
        PostWithComments pwc  = serviceLayer.createPost(post);

        PostWithComments pwc1 = serviceLayer.findPost(pwc.getPostID());
        assertEquals(pwc, pwc1);

        List<PostWithComments> posts = serviceLayer.findAllPosts();
        assertEquals(posts.size(), 1);
        assertEquals(pwc, posts.get(0));
        serviceLayer.findAllPostsByPoster("Fred Weasley");
        assertEquals(1, posts.size());
    }
    @Test
    public void updatePost() {
        PostWithComments pwc = serviceLayer.findPost(1);
        pwc.setPostID(1);
        pwc.setPostDate(LocalDate.of(2019, 8, 13));
        pwc.setPosterName("George Weasley");
        pwc.setPost("Voldemort sucks.");
        pwc.setComments(commentClient.findAllCommentsByPostId(1));

        serviceLayer.updatePost(pwc);

        ArgumentCaptor<Post> postCaptor = ArgumentCaptor.forClass(Post.class);
        Mockito.verify(postClient).updatePost(postCaptor.capture());
        assertEquals(pwc.getPosterName(), postCaptor.getValue().getPosterName());
    }
    @Test
    public void deletePost() {
        PostWithComments pwc = serviceLayer.findPost(1);
        serviceLayer.deletePost(1);

        ArgumentCaptor<Integer> postCaptor = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(postClient).deletePost(postCaptor.capture());
        assertEquals(pwc.getPostID(), postCaptor.getValue().intValue());
    }
    @Test
    public void createComment() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 8, 13));
        comment.setCommenterName("George Weasley");
        comment.setComment("Totes agree!");
        serviceLayer.createComment(comment);
        commentClient.createComment(comment);
        ArgumentCaptor<Comment> commentCaptor = ArgumentCaptor.forClass(Comment.class);
        Mockito.verify(commentClient).createComment(commentCaptor.capture());
        assertEquals(comment.getCommentId(), commentCaptor.getValue().getCommentId());
    }
    @Test
    public void FindFindAllAndFindAllByPostId() {
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 8, 13));
        comment.setCommenterName("George Weasley");
        comment.setComment("Totes agree!");

        Comment comment1 = commentClient.findComment(1);
        assertEquals(comment, comment1);
        List<Comment> comments = commentClient.findAllComments();
        assertEquals(comments.size(), 1);
        List<Comment> commentsByID = commentClient.findAllCommentsByPostId(1);
        assertEquals(commentsByID.size(), 1);
    }
    @Test
    public void updateComment() {
        Comment comment = serviceLayer.findComment(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 8, 13));
        comment.setCommenterName("George Weasley");
        comment.setComment("Totes agree!");
        serviceLayer.updateComment(comment);
        commentClient.updateComment(comment);
        ArgumentCaptor<Comment> commentCaptor = ArgumentCaptor.forClass(Comment.class);
        Mockito.verify(commentClient).updateComment(commentCaptor.capture());
        assertEquals(comment.getCommentId(), commentCaptor.getValue().getCommentId());
    }
    @Test
    public void deleteComment() {
        Comment comment = commentClient.findComment(1);
        serviceLayer.deleteComment(1);

        ArgumentCaptor<Integer> commentCaptor = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(commentClient).deleteComment(commentCaptor.capture());
        assertEquals(comment.getCommentId(), commentCaptor.getValue().intValue());
    }
}