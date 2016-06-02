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
import ru.kpfu.itis.group408.marushkai.dao.*;
import ru.kpfu.itis.group408.marushkai.domain.*;
import ru.kpfu.itis.group408.marushkai.service.interfaces.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ServicesTest {
    @Configuration
    static class ProductServiceTestContextConfiguration {
        @Bean
        public PostService<Post> postService() {
            return new PostServiceImpl();
        }

        @Bean
        public PostDAO postDAO() {
            return Mockito.mock(PostDAO.class);
        }

        @Bean
        public ContestantService<Contestant> contestantService() {
            return new ContestantServiceImpl();
        }

        @Bean
        public ContestantDAO contestantDAO() {
            return Mockito.mock(ContestantDAO.class);
        }

        @Bean
        public AdvertService advertService() {
            return new AdvertServiceImpl();
        }

        @Bean
        public AdvertDao advertDao() {
            return Mockito.mock(AdvertDao.class);
        }

        @Bean
        public SessionFactory sessionFactory() {
            return Mockito.mock(SessionFactory.class);
        }

        @Bean
        public StandingService<Standing> standingService() {
            return new StandingServiceImpl();
        }

        @Bean
        public StandingDAO standingDAO() {
            return new StandingDAO();
        }

        @Bean
        public TeamService<Team> teamService() {
            return new TeamServiceImpl();
        }

        @Bean
        public TeamDAO teamDAO() {
            return Mockito.mock(TeamDAO.class);
        }

        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }

        @Bean
        public UserDAO userDAO() {
            return Mockito.mock(UserDAO.class);
        }
    }



    @Autowired
    private ContestantService<Contestant> contestantService;

    @Autowired
    private AdvertService advertService;

    @Autowired
    private AdvertDao advertDao;

    @Autowired
    private ContestantDAO contestantDAO;

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private PostService<Post> postService;


    @Test
    public void listEastSideTest() {
        ArrayList<Contestant> contActual = new ArrayList<>();
        contActual.add(new Contestant("1", "2", "smth", "east"));
        contActual.add(new Contestant("1", "3", "smth1", "east"));
        contActual.add(new Contestant("2", "1", "smth", "west"));
        Mockito.when(contestantService.listContestants()).thenReturn(contActual);

        List<Contestant> contestants = new ArrayList<>();
        contestants.add(new Contestant("1", "2", "smth", "east"));
        contestants.add(new Contestant("1", "2", "smth1", "east"));

        for (int i = 0; i < contestants.size(); i++) {
            assertEquals(contestants.get(i).getRegion(), contestantService.listEastSide().get(i).getRegion());
        }
    }

    @Test
    public void listWestSideTest() {
        ArrayList<Contestant> contActual = new ArrayList<>();
        contActual.add(new Contestant("1", "2", "smth", "east"));
        contActual.add(new Contestant("1", "3", "smth1", "east"));
        contActual.add(new Contestant("2", "1", "smth", "west"));
        Mockito.when(contestantService.listContestants()).thenReturn(contActual);

        List<Contestant> contestants = new ArrayList<>();
        contestants.add(new Contestant("1", "2", "smth", "west"));

        for (int i = 0; i < contestants.size(); i++) {
            assertEquals(contestants.get(i).getRegion(), contestantService.listWestSide().get(i).getRegion());
        }
    }

    @Test
    public void advertGetTest() {
        Mockito.when(advertDao.getById(1)).thenReturn(new Advert("one", "/images/smth.jpeg", "http://vk.com"));
        assertNotNull(advertService.get(1));
    }

    @Test
    public void listContestantsPostTest() {
        ArrayList<Post> contActual = new ArrayList<>();
        contActual.add(new Post("one", "smth", "smth1"));
        contActual.add(new Post("one", "smth", "smth1"));
        contActual.add(new Post("one", "smth", "smth1"));

        Mockito.when(postDAO.listContestants()).thenReturn(contActual);

        assertEquals(postService.listContestants(), contActual);
    }



}