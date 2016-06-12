package ru.kpfu.itis.group408.marushkai.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.group408.marushkai.domain.Comment;
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
    public void deleteById(Integer id) throws Exception {
        List<Comment> comments = getCommentsByPostId(id);
        for (Comment comment : comments) {
            this.deleteCommentById(comment.getCommentId());
        }
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
            sessionFactory.getCurrentSession().createQuery("delete from Post where id = ?").setInteger(0, post.getId()).executeUpdate();
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

    public void updatePost(Post post) {
        sessionFactory.getCurrentSession().update(post);
    }

    public void addComment(Comment comment) {
        sessionFactory.getCurrentSession().save(comment);
    }

    public List<Comment> getCommentsByPostId(Integer postId){
        return sessionFactory.getCurrentSession().createQuery("from Comment where ID = " + postId).list();
    }

    public Comment getCommentById(Integer commentId){
        return (Comment) sessionFactory.getCurrentSession().load(Comment.class, commentId);
    }

    public void deleteCommentById(Integer id) throws Exception{
        Comment comment = this.getCommentById(id);
        if (comment != null){
            sessionFactory.getCurrentSession().delete(comment);
        } else {
            throw new Exception("No such comment found");
        }

    }
}
