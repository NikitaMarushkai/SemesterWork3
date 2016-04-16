package ru.kpfu.itis.group408.marushkai.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.group408.marushkai.domain.user.User;
import ru.kpfu.itis.group408.marushkai.service.interfaces.UserService;

/**
 * Created by unlim_000 on 07.04.2016.
 */

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    UserService userService;

    @RequestMapping("/show")
    public String showProfile(ModelMap model) {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("userName", user.getUsername());
        model.addAttribute("name", user.getName());
        model.addAttribute("surname", user.getSurname());
        model.addAttribute("patronymic", user.getPatronymic());
        model.addAttribute("login", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("comment", user.getComment());
        return "profile";
    }

    @RequestMapping("/changePassword")
    public String changePassword(@RequestParam("oldPassword") String oldPlainPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 @RequestParam("newPasswordCheck") String newPasswordCheck,
                                 ModelMap map) {

        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        String oldUserPassword = user.getPassword();

        if (BCrypt.checkpw(oldPlainPassword, oldUserPassword)) {
            if (newPassword.equals(newPasswordCheck)) {
                user.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt(15)));
                userService.updateUser(user);
            } else {
                map.addAttribute("passwordChangeException", "Пароли не совпадают");
                return this.showProfile(map);
            }
        } else {
            map.addAttribute("passwordChangeException", "Вы ввели неверный пароль");
            return this.showProfile(map);
        }
        map.addAttribute("passwordChangeException", "Пароль успешно изменен");
        return this.showProfile(map);
    }
}
