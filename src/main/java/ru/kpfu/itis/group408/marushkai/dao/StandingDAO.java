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

    //ИСПОЛЬЗОВАТЬ ТОЛЬКО getByName!!!
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Standing toAdd) {
        sessionFactory.getCurrentSession().save(toAdd);
    }

    @Override
    @Deprecated
    public void deleteById(Integer id) throws Exception {
        throw new Exception("Impossible to delete by ID, use deleteByName instead");
    }

    @Override
    public void deleteByName(String name) throws NullPointerException {
        Standing standing = this.getByName(name);
        if (standing != null) {
            sessionFactory.getCurrentSession().delete(standing);
        } else throw new NullPointerException("No such name found");
    }

    @Override
    public Standing getByName(String name) {
        return (Standing) sessionFactory.getCurrentSession().load(Standing.class, name);
    }

    @Override
    @Deprecated
    public Standing getById(Integer id) throws Exception {
        throw new Exception("Impossible to get by ID, use getByName instead");
    }

    @Override
    public List<Standing> listContestants() {
        return sessionFactory.getCurrentSession().createQuery("from Standing").list();
    }
}
