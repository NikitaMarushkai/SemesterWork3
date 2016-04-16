package ru.kpfu.itis.group408.marushkai.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group408.marushkai.domain.user.Authority;
import ru.kpfu.itis.group408.marushkai.domain.user.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by unlim_000 on 06.04.2016.
 */
@Repository
public class UserDAOImpl implements UserDAO {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addUser(User user, Authority authority) {
        sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().save(authority);
    }

    @Override
    public void removeUser(String username) throws NullPointerException {
        User user = (User) sessionFactory.getCurrentSession().load(User.class, username);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        } else throw new NullPointerException("No such user in the table");
    }

    @Override
    public Map<User, List<Authority>> showUsers() {
        Map<User, List<Authority>> usersMap = new HashMap<>();
        List<User> userEntities = sessionFactory.getCurrentSession().createQuery("from User").list();
        List<List<Authority>> authoritiesEnd = new LinkedList<>();
        for (User user : userEntities) {
            authoritiesEnd.add(sessionFactory.getCurrentSession().createQuery("from Authority, where " +
                    "username = " + user.getUsername()).list());
        }
        for (User user : userEntities) {
            for (List<Authority> auth : authoritiesEnd) {
                if (user.getUsername().equals(auth.get(0).getUsername())) {
                    usersMap.put(user, auth);
                }
            }
        }
        return usersMap;
    }

    @Override
    public User getUser(String username) {
        return (User) sessionFactory.openSession().load(User.class, username);

    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().merge(user);
    }
}
