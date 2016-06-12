package ru.kpfu.itis.group408.marushkai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.group408.marushkai.annotation.TimeLog;
import ru.kpfu.itis.group408.marushkai.dao.UserDAO;
import ru.kpfu.itis.group408.marushkai.domain.user.Authority;
import ru.kpfu.itis.group408.marushkai.domain.user.User;
import ru.kpfu.itis.group408.marushkai.service.interfaces.UserService;

import java.util.List;
import java.util.Map;

/**
 * Created by unlim_000 on 06.04.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Transactional
    @Override
    public void addUser(User user, Authority authority) {
        userDAO.addUser(user, authority);
    }

    @Transactional
    @Override
    public void removeUser(String username) throws NullPointerException {
        userDAO.removeUser(username);
    }

    @Transactional
    @Override
    public Map<User, List<Authority>> showUsers() {
        return userDAO.showUsers();
    }

    @Transactional
    @Override
    public User getUser(String username) {
        return userDAO.getUser(username);
    }

    @Transactional
    @Override
    @TimeLog
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
}
