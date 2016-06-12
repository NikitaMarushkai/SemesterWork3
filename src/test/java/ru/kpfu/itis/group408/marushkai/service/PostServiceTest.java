package ru.kpfu.itis.group408.marushkai.service;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.kpfu.itis.group408.marushkai.dao.PostDAO;
import ru.kpfu.itis.group408.marushkai.domain.Comment;
import ru.kpfu.itis.group408.marushkai.domain.Post;
import ru.kpfu.itis.group408.marushkai.domain.user.User;
import ru.kpfu.itis.group408.marushkai.service.interfaces.PostService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by unlim_000 on 06.06.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PostServiceTest {

    @Configuration
    static class ProductServiceTestContextConfiguration {
        @Bean
        public SessionFactory sessionFactory() {
            return Mockito.mock(SessionFactory.class);
        }

        @Bean
        public PostService<Post> postService() {
            return new PostServiceImpl();
        }

        @Bean
        public PostDAO postDAO() {
            return Mockito.mock(PostDAO.class);
        }
    }

    @Autowired
    PostService<Post> postService;

    @Autowired
    PostDAO postDAO;

    @Test
    public void listContestantsPostTest() throws ParseException {
        ArrayList<Post> contActual = new ArrayList<>();
        contActual.add(new Post("one", "smth", "smth1"));
        contActual.add(new Post("one", "smth", "smth1"));
        contActual.add(new Post("one", "smth", "smth1"));

        Mockito.when(postDAO.listContestants()).thenReturn(contActual);

        assertEquals(postService.listContestants(), contActual);
    }

    @Test
    public void testGetById() throws Exception {
        Post post = new Post("someone", "asd", "abc");
        Mockito.when(postDAO.getById(1)).thenReturn(post);
        assertEquals(postService.getById(1), post);
    }

    @Test
    public void getCommentsByPostIdTest(){
        Comment comment = new Comment("text", new Post("1", "2", "3"), new User("1", "2", 1, "", "", "", "", ""));
        Comment comment1 = new Comment("text", new Post("1", "2", "3"), new User("1", "2", 1, "", "", "", "", ""));
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        comments.add(comment1);

        Mockito.when(postDAO.getCommentsByPostId(1)).thenReturn(comments);

        assertEquals(postService.getCommentsByPostId(1), comments);
    }
}
