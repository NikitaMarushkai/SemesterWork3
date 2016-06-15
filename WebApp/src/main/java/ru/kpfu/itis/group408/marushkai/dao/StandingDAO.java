package ru.kpfu.itis.group408.marushkai.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group408.marushkai.domain.Standing;

import java.util.List;

/**
 * Created by unlim_000 on 19.03.2016.
 */
@Repository
public class StandingDAO implements DAO<Standing> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Standing toAdd) {
        sessionFactory.getCurrentSession().save(toAdd);
    }

    @Override
    public void deleteById(Integer id) {
        Standing standing = this.getById(id);
        if (standing != null){
            sessionFactory.getCurrentSession().delete(standing);
        } else throw new NullPointerException("No such element");
    }

    @Override
    public void deleteByName(String name) throws NullPointerException {
        Standing standing = this.getByName(name);
        if (standing != null) {
            sessionFactory.getCurrentSession().delete(standing);
        } else throw new NullPointerException("No such name found");
    }

    @Override
    @Deprecated
    public Standing getByName(String name) {
        return (Standing) sessionFactory.getCurrentSession().createQuery("from Standing where team = \'" +
                name + "\'").list().get(0);
    }

    @Override
    public Standing getById(Integer id) {
        return (Standing) sessionFactory.getCurrentSession().load(Standing.class, id);
    }

    @Override
    public List<Standing> listContestants() {
        return sessionFactory.getCurrentSession().createQuery("from Standing").list();
    }

    public void updateStanding(Standing standing) {
        sessionFactory.getCurrentSession().delete(standing);
        sessionFactory.getCurrentSession().save(standing);
    }
}
