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
import ru.kpfu.itis.group408.marushkai.dao.ContestantDAO;
import ru.kpfu.itis.group408.marushkai.domain.Contestant;
import ru.kpfu.itis.group408.marushkai.service.interfaces.ContestantService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ContestantServiceTest {
    @Configuration
    static class ProductServiceTestContextConfiguration {

        @Bean
        public ContestantService<Contestant> contestantService() {
            return new ContestantServiceImpl();
        }

        @Bean
        public ContestantDAO contestantDAO() {
            return Mockito.mock(ContestantDAO.class);
        }


        @Bean
        public SessionFactory sessionFactory() {
            return Mockito.mock(SessionFactory.class);
        }

    }



    @Autowired
    private ContestantService<Contestant> contestantService;

    @Autowired
    private ContestantDAO contestantDAO;


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





}