package ru.kpfu.itis.group408.marushkai.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.group408.marushkai.domain.Post;
import ru.kpfu.itis.group408.marushkai.domain.user.Authority;
import ru.kpfu.itis.group408.marushkai.domain.user.User;
import ru.kpfu.itis.group408.marushkai.service.interfaces.PostService;
import ru.kpfu.itis.group408.marushkai.service.interfaces.UserService;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by unlim_000 on 30.03.2016.
 */

@Controller
public class AdministrativeController {

    @Autowired
    PostService<Post> postService;

    @Autowired
    UserService userService;

    @RequestMapping("admin/addPost/{category}")
    public String addOrDeletePost(@PathVariable("category") String category, Map<String, Object> map,
                                  @RequestParam(name = "name", required = false) Integer id,
                                  @RequestParam(name = "head", required = false) String postHead,
                                  @RequestParam(name = "content", required = false) String postContent,
                                  @RequestParam(name = "photo", required = false) String postPhoto) {
        switch (category) {
            case "news":
                postService.add(new Post(postHead, postContent, postPhoto));
                return "redirect:/news";
            case "delete":
                try {
                    postService.deleteById(id);
                } catch (Exception e) {
                    map.put("alert", "Impossible to delete by ID, ID is missing");
                }
                return "redirect:/news";
        }
        return null;
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
