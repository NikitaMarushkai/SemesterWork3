package ru.kpfu.itis.group408.marushkai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.group408.marushkai.dao.PostDAO;
import ru.kpfu.itis.group408.marushkai.domain.Post;
import ru.kpfu.itis.group408.marushkai.service.interfaces.PostService;

import java.util.List;

/**
 * Created by unlim_000 on 25.03.2016.
 */
@Service
public class PostServiceImpl implements PostService<Post> {

    @Autowired
    PostDAO postDAO;

    @Transactional
    @Override
    public void add(Post toAdd) {
        postDAO.add(toAdd);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) throws Exception {
        postDAO.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByName(String name) {
        postDAO.deleteByName(name);
    }

    @Transactional
    @Override
    public Post getByName(String name) {
        return postDAO.getByName(name);
    }

    @Transactional
    @Override
    public Post getById(Integer id) throws Exception {
        return postDAO.getById(id);
    }

    @Transactional
    @Override
    public List<Post> listContestants() {
        return postDAO.listContestants();
    }
}
