package ru.kpfu.itis.group408.marushkai.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.group408.marushkai.domain.user.Authority;
import ru.kpfu.itis.group408.marushkai.domain.user.User;
import ru.kpfu.itis.group408.marushkai.service.interfaces.StandingService;
import ru.kpfu.itis.group408.marushkai.service.interfaces.UserService;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by unlim_000 on 25.03.2016.
 */

@Controller
public class IndexController {

    @Autowired
    private StandingService standingService;

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String showIndex(Map<String, Object> map) {
        map.put("loginMark", SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
        map.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
        map.put("west", standingService.getWestSide());
        map.put("east", standingService.getEastSide());
        return "index";
    }

    @RequestMapping("/adminConsole")
    public String showAdmin() {
        return "admin";
    }

    @RequestMapping("/register")
    public String registerUser(@RequestParam(name = "name") String name,
                               @RequestParam(name = "surname") String surname,
                               @RequestParam(name = "patronymic") String patronymic,
                               @RequestParam(name = "login") String login,
                               @RequestParam(name = "email") String email,
                               @RequestParam(name = "password") String password,
                               @RequestParam(name = "password-check") String passwordCheck,
                               @RequestParam(name = "comment") String aboutYourself,
                               Map<String, Object> map) {


        if (password.equals(passwordCheck)) {
//            if (userService.getUser(login) == null){
            String encodedPassword = BCrypt.hashpw(password, BCrypt.gensalt(15));
            User user = new User(login, encodedPassword, 1, name, surname, patronymic, email, aboutYourself);
            Authority authority = new Authority("user", user);
            Set<Authority> authorities = new HashSet<>();
            authorities.add(authority);
            user.setAuthorities(authorities);
            userService.addUser(user, authority);
            /*}*/ /*else {
                map.put("exception", "Такой пользователь уже зарегистрирован");
                return "Registration";
            }*/
        } else {
            map.put("exception", "Пароли не совпадают");
            return "Registration";
        }
        return "redirect:/index";
    }
}
