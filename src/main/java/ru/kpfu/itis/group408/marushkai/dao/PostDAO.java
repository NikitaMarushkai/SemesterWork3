package ru.kpfu.itis.group408.marushkai.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group408.marushkai.domain.Post;

import java.util.List;

/**
 * Created by unlim_000 on 19.03.2016.
 */
@Repository
public class PostDAO implements DAO<Post> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Post toAdd) {
        sessionFactory.getCurrentSession().save(toAdd);
    }

    @Override
    public void deleteById(Integer id) throws NullPointerException {
        Post post = this.getById(id);
        if (post != null) {
            sessionFactory.getCurrentSession().delete(post);
        } else {
            throw new NullPointerException("No such post found, nothing to delete");
        }
    }

    @Override
    public void deleteByName(String name) throws NullPointerException {
        Post post = this.getByName(name);
        if (post != null) {
            sessionFactory.getCurrentSession().delete(post);
        } else {
            throw new NullPointerException("No such post found");
        }
    }

    @Override
    public Post getByName(String name) {
        return (Post) sessionFactory.getCurrentSession().load(Post.class, name);
    }

    @Override
    public Post getById(Integer id) {
        return (Post) sessionFactory.getCurrentSession().load(Post.class, id);
    }

    @Override
    public List<Post> listContestants() {
        return sessionFactory.getCurrentSession().createQuery("from Post").list();
    }
}
