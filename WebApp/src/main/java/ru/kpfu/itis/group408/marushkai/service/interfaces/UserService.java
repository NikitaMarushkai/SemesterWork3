package ru.kpfu.itis.group408.marushkai.service.interfaces;

import ru.kpfu.itis.group408.marushkai.domain.user.Authority;
import ru.kpfu.itis.group408.marushkai.domain.user.User;

import java.util.List;
import java.util.Map;

/**
 * Created by unlim_000 on 06.04.2016.
 */
public interface UserService {
    void addUser(User user, Authority authority);

    void removeUser(String username) throws NullPointerException;

    Map<User, List<Authority>> showUsers();

    User getUser(String username);

    void updateUser(User user);
}
