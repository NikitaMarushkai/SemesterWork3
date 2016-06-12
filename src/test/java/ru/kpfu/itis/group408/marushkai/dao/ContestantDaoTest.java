package ru.kpfu.itis.group408.marushkai.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.group408.marushkai.domain.Contestant;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by unlim_000 on 12.06.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config.xml")
public class ContestantDaoTest {

    private Contestant contestant;
    private List<Contestant> contestants;


    @Autowired
    ContestantDAO contestantDAO;

    @Before
    public void init(){
        //single
        contestant = new Contestant("team1", "team2", "someDate", "east");

        //list
        contestants = new ArrayList<>();
        contestants.add(new Contestant("team1", "team2", "someDate", "east"));
        contestants.add(new Contestant("team1", "team2", "someDate", "east"));
        contestants.add(new Contestant("team1", "team2", "someDate", "east"));
        contestants.add(new Contestant("team1", "team2", "someDate", "west"));
        contestants.add(new Contestant("team1", "team2", "someDate", "west"));
    }


    @Test
    @Transactional
    public void testGetAll(){
        for (Contestant cont : contestants) {
            contestantDAO.add(cont);
        }
        assertEquals(contestants.size(), contestantDAO.listContestants().size());
    }

    @Test
    @Transactional
    public void testGetById(){
        contestantDAO.add(contestant);
        int id = contestant.getId();
        assertEquals(contestant, contestantDAO.getById(id));
    }

    @Test
    @Transactional
    public void testDeleteById(){
        contestantDAO.add(contestant);
        int id = contestant.getId();
        int size = contestantDAO.listContestants().size();
        contestantDAO.deleteById(id);
        assertEquals(size - 1, contestantDAO.listContestants().size());
    }
}
