package ru.kpfu.itis.group408.marushkai.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.group408.marushkai.domain.Advert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by unlim_000 on 12.06.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config.xml")
public class AdvertDaoTest {

    @Autowired
    AdvertDao advertDao;


    @Test
    @Transactional
    public void testGetAdvertById(){
        Advert advert = new Advert("hello", "url", "http://smth.com");
        advertDao.add(advert);
        int id = advert.getId();
        assertEquals(advert, advertDao.getById(id));
    }

    @Test
    @Transactional
    public void testGetAllAdverts(){
        Advert advert = new Advert("hello", "img", "smth");
        Advert advert1 = new Advert("hello", "img", "smth");
        advertDao.add(advert);
        advertDao.add(advert1);
        List<Advert> advertsAct = new ArrayList<>();
        advertsAct.add(advert);
        advertsAct.add(advert1);

        List<Advert> advertList = advertDao.listContestants();

        assertEquals(advertsAct.size(), advertList.size());
    }

    @Test
    @Transactional
    public void testDeleteById(){
        Advert advert = new Advert("hello", "img", "smth");
        advertDao.add(advert);
        int advId = advert.getId();
        int size = advertDao.listContestants().size();
        advertDao.deleteById(advId);

        assertEquals(size - 1, advertDao.listContestants().size());
    }
}
