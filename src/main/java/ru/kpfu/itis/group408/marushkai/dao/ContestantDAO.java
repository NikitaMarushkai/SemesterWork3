package ru.kpfu.itis.group408.marushkai.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group408.marushkai.domain.Contestant;

import java.util.List;

/**
 * Created by unlim_000 on 19.03.2016.
 */
@Repository
public class ContestantDAO implements DAO<Contestant> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Contestant toAdd) {
        sessionFactory.getCurrentSession().save(toAdd);
    }

    @Override
    public void deleteById(Integer id) throws NullPointerException {
        Contestant contestant = this.getById(id);
        if (contestant != null) {
            sessionFactory.getCurrentSession().delete(contestant);
        } else {
            throw new NullPointerException("No such contestant, nothing to delete");
        }
    }

    @Override
    public void deleteByName(String name) throws NullPointerException {
        Contestant contestant = this.getByName(name);
        if (contestant != null) {
            sessionFactory.getCurrentSession().delete(contestant);
        } else {
            throw new NullPointerException("No such contestant");
        }
    }

    @Override
    public Contestant getByName(String name) {
        return (Contestant) sessionFactory.getCurrentSession().load(Contestant.class, name);
    }

    @Override
    public Contestant getById(Integer id) {
        return (Contestant) sessionFactory.getCurrentSession().load(Contestant.class, id);
    }

    @Override
    public List<Contestant> listContestants() {
        return sessionFactory.getCurrentSession().createQuery("from Contestant").list();
    }
}
