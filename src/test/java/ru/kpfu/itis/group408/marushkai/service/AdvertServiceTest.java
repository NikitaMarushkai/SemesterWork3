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
import ru.kpfu.itis.group408.marushkai.dao.AdvertDao;
import ru.kpfu.itis.group408.marushkai.domain.Advert;
import ru.kpfu.itis.group408.marushkai.service.interfaces.AdvertService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by unlim_000 on 06.06.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AdvertServiceTest {
    @Configuration
    static class ProductServiceTestContextConfiguration {

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

    }

    @Autowired
    AdvertDao advertDao;

    @Autowired
    AdvertService advertService;

    @Test
    public void advertGetTest() {
        Mockito.when(advertDao.getById(1)).thenReturn(new Advert("one", "/images/smth.jpeg", "http://vk.com"));
        assertNotNull(advertService.get(1));
    }

    @Test
    public void advertGetAllTest(){
        List<Advert> adverts = new ArrayList<>();
        adverts.add(new Advert("Adv txt", "abc", "bc.com"));
        adverts.add(new Advert("Adv txt", "abc", "bc.com"));
        Mockito.when(advertDao.listContestants()).thenReturn(adverts);
        assertEquals(advertService.getAll(), adverts);
    }
}
