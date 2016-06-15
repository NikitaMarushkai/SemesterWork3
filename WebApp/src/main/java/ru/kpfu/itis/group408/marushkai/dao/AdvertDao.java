package ru.kpfu.itis.group408.marushkai.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group408.marushkai.domain.Advert;

import java.util.List;

/**
 * Created by unlim_000 on 02.06.2016.
 */

@Repository
public class AdvertDao implements DAO<Advert> {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void add(Advert toAdd) {
        sessionFactory.getCurrentSession().save(toAdd);
    }

    @Override
    public void deleteById(Integer id) {
        Advert advert = this.getById(id);
        if (advert != null) {
            sessionFactory.getCurrentSession().delete(advert);
        } else {
            throw new NullPointerException("No such advert, nothing to delete");
        }
    }

    @Override
    @Deprecated
    public void deleteByName(String name) {
        //not needed
    }

    @Override
    @Deprecated
    public Advert getByName(String name) {
        return null;
    }

    @Override
    public Advert getById(Integer id) {
        return (Advert) sessionFactory.getCurrentSession().load(Advert.class, id);
    }

    @Override
    public List<Advert> listContestants() {
        return sessionFactory.getCurrentSession().createQuery("from Advert").list();
    }
}
