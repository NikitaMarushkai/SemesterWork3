package ru.kpfu.itis.group408.marushkai.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.group408.marushkai.domain.Standing;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by unlim_000 on 12.06.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config.xml")
public class StandingDaoTest {

    private Standing standing;
    private List<Standing> standings;

    @Autowired
    StandingDAO standingDAO;

    @Before
    public void init(){
        //single
        standing = new Standing("1", "east", 1, 2, 3, 4, 5, 6, 7 ,8, 9);

        //multiple
        Standing standing1 = new Standing("1", "east", 1, 2, 3, 4, 5, 6, 7 ,8, 9);
        Standing standing2 = new Standing("1", "east", 1, 2, 3, 4, 5, 6, 7 ,8, 9);
        Standing standing3 = new Standing("1", "east", 1, 2, 3, 4, 5, 6, 7 ,8, 9);
        Standing standing4 = new Standing("1", "west", 1, 2, 3, 4, 5, 6, 7 ,8, 9);
        Standing standing5 = new Standing("1", "west", 1, 2, 3, 4, 5, 6, 7 ,8, 9);
        Standing standing6 = new Standing("1", "west", 1, 2, 3, 4, 5, 6, 7 ,8, 9);
        standings = new ArrayList<>();
        standings.add(standing1);
        standings.add(standing2);
        standings.add(standing3);
        standings.add(standing4);
        standings.add(standing5);
        standings.add(standing6);
    }

    @Test
    @Transactional
    public void testGetAll(){
        for (Standing standing : standings){
            standingDAO.add(standing);
        }
        assertEquals(standings.size(), standingDAO.listContestants().size());
    }

    @Test
    @Transactional
    public void testGetById(){
        standingDAO.add(standing);
        int id = standing.getId();

        assertEquals(standing, standingDAO.getById(id));
    }

    @Test
    @Transactional
    public void testDeleteById() throws Exception {
        standingDAO.add(standing);
        int id = standing.getId();
        int size = standingDAO.listContestants().size();
        standingDAO.deleteById(id);

        assertEquals(size - 1, standingDAO.listContestants().size());
    }

}
