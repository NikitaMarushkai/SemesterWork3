package ru.kpfu.itis.group408.marushkai.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.group408.marushkai.dao.PostDAO;
import ru.kpfu.itis.group408.marushkai.domain.Post;
import ru.kpfu.itis.group408.marushkai.gwt.client.AddPostService;

import java.util.List;

/**
 * Created by unlim_000 on 16.04.2016.
 */

@Service(value = "addPostService")
public class AddPostServiceImpl implements AddPostService {

    @Autowired
    PostDAO postDAO;

    @Override
    public void add() {

    }

    @Override
    @Transactional
    public List<Post> getAllPosts() {
        return postDAO.listContestants();
    }

//    private static int toShowSize = 5;
//
//    @Autowired
//    PostService<Post> postService;
//
////    @Autowired
////    AdministrativeController controller;
//
//    @Override
//    public void add() {
////        controller.
//    }
}