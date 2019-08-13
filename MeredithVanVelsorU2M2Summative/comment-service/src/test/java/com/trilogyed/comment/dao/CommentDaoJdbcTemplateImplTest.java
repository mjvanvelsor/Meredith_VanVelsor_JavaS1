package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDaoJdbcTemplateImplTest {

    @Autowired
    CommentDao dao;

    @Before
    public void setUp() throws Exception {
        List<Comment> comments = dao.getAllComments();
        comments.stream().forEach(comment -> dao.deleteComment(comment.getCommentId()));
    }

    @Test
    public void addGetDeleteComment() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 8, 13));
        comment.setCommenterName("George");
        comment.setComment("This is a comment.");
        dao.addComment(comment);
        assertEquals(comment, dao.getComment(comment.getCommentId()));
        dao.deleteComment(comment.getCommentId());
        assertNull(dao.getComment(comment.getCommentId()));
    }

    @Test
    public void getAllCommentsAndGetByPostId() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 8, 13));
        comment.setCommenterName("George");
        comment.setComment("This is a comment.");
        dao.addComment(comment);
        Comment comment1 = new Comment();
        comment1.setPostId(2);
        comment1.setCreateDate(LocalDate.of(2019, 8, 14));
        comment1.setCommenterName("Tom");
        comment1.setComment("This is a comment.");
        dao.addComment(comment1);

        List<Comment> comments = dao.getAllComments();
        assertEquals(comments.size(), 2);
        List<Comment> commentsById = dao.getAllCommentsByPostId(1);
        assertEquals(1, commentsById.size());
    }

    @Test
    public void updateComment() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 8, 13));
        comment.setCommenterName("George");
        comment.setComment("This is a comment.");
        dao.addComment(comment);
        comment.setComment("This is a different comment.");
        dao.updateComment(comment);
        assertEquals(comment, dao.getComment(comment.getCommentId()));
    }


}