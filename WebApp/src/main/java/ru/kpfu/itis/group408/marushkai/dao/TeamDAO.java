package ru.kpfu.itis.group408.marushkai.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group408.marushkai.domain.Team;

import java.util.List;

/**
 * Created by unlim_000 on 19.03.2016.
 */
@Repository
public class TeamDAO implements DAO<Team> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Team toAdd) {
        sessionFactory.getCurrentSession().save(toAdd);
    }

    @Override
    public void deleteById(Integer id) throws NullPointerException {
        Team team = (Team) sessionFactory.getCurrentSession().load(Team.class, id);
        if (team != null) {
            sessionFactory.getCurrentSession().delete(team);
        } else {
            throw new NullPointerException("No such team, nothing to delete");
        }
    }

    @Override
    public void deleteByName(String name) throws NullPointerException {
        Team team = this.getByName(name);
        if (team != null) {
            sessionFactory.getCurrentSession().delete(team);
        } else {
            throw new NullPointerException("No such team found");
        }
    }

    @Override
    public Team getByName(String name) {
        return (Team) sessionFactory.getCurrentSession().load(Team.class, name);
    }

    @Override
    public Team getById(Integer id) {
        return (Team) sessionFactory.getCurrentSession().load(Team.class, id);
    }

    @Override
    public List<Team> listContestants() {
        return sessionFactory.getCurrentSession().createQuery("from Team").list();
    }
}
