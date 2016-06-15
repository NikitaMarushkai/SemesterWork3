package ru.kpfu.itis.group408.marushkai.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.group408.marushkai.dao.AdvertDao;
import ru.kpfu.itis.group408.marushkai.dao.ContestantDAO;
import ru.kpfu.itis.group408.marushkai.dao.PostDAO;
import ru.kpfu.itis.group408.marushkai.dao.StandingDAO;
import ru.kpfu.itis.group408.marushkai.domain.Advert;
import ru.kpfu.itis.group408.marushkai.domain.Contestant;
import ru.kpfu.itis.group408.marushkai.domain.Post;
import ru.kpfu.itis.group408.marushkai.domain.Standing;
import ru.kpfu.itis.group408.marushkai.gwt.client.AddPostService;

import java.util.List;

/**
 * Created by unlim_000 on 16.04.2016.
 */

@Service(value = "addPostService")
public class AddPostServiceImpl implements AddPostService {

    @Autowired
    PostDAO postDAO;

    @Autowired
    StandingDAO standingDAO;

    @Autowired
    AdvertDao advertDao;

    @Autowired
    ContestantDAO contestantDAO;

    @Override
    public void add() {

    }

    @Override
    @Transactional
    public List<Post> getAllPosts() {
        return postDAO.listContestants();
    }

    @Override
    @Transactional
    public List<Standing> getAllTeams() {
        return standingDAO.listContestants();
    }

    @Override
    @Transactional
    public List<Advert> getAllAdverts() {
        return advertDao.listContestants();
    }

    @Override
    @Transactional
    public List<Contestant> getAllContestants() {
        return contestantDAO.listContestants();
    }


}
