package ru.kpfu.itis.group408.marushkai.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.group408.marushkai.domain.Comment;
import ru.kpfu.itis.group408.marushkai.domain.Post;
import ru.kpfu.itis.group408.marushkai.domain.user.Authority;
import ru.kpfu.itis.group408.marushkai.domain.user.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by unlim_000 on 12.06.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config.xml")
public class PostDaoTest {

    private Post post;
    private List<Post> posts;
    private Comment comment;
    private List<Comment> comments;
    private User user;

    @Autowired
    PostDAO postDAO;
    @Autowired
    UserDAO userDAO;


    @Before
    public void init(){
        //single post
        post = new Post("first", "image", "content");
        //single comment
        user = new User("123", "123", 1, "user", "us", "as", "sad", "asdda");
        comment = new Comment("smth", post, user);

        //comments
        Comment comment1 = new Comment("smth", post, user);
        Comment comment2 = new Comment("smth", post, user);
        Comment comment3 = new Comment("smth", post, user);
        comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        comments.add(comment3);

        //multi
        Post post1 = new Post("first", "image", "content");
        Post post2 = new Post("first", "image", "content");
        Post post3 = new Post("first", "image", "content");
        Post post4 = new Post("first", "image", "content");
        posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
    }

    @Test
    @Transactional
    public void testGetAllPosts(){
        for (Post post : posts){
            postDAO.add(post);
        }

        assertEquals(posts.size(), postDAO.listContestants().size());
    }

    @Test
    @Transactional
    public void testGetCommentsByPostId(){
        postDAO.add(post);
        userDAO.addUser(user, new Authority("user", user));
        for (Comment comment : comments){
            postDAO.addComment(comment);
        }
        int id = post.getId();
        assertEquals(comments.size(), postDAO.getCommentsByPostId(id).size());
    }

    @Test
    @Transactional
    public void testGetCommentById(){
        postDAO.add(post);
        userDAO.addUser(user, new Authority("user", user));
        postDAO.addComment(comment);

        assertEquals(comment, postDAO.getCommentById(comment.getCommentId()));
    }
}
