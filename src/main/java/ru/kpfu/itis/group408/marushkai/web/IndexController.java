package ru.kpfu.itis.group408.marushkai.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.group408.marushkai.service.StandingService;

import java.util.Map;

/**
 * Created by unlim_000 on 25.03.2016.
 */

@Controller
public class IndexController {

    @Autowired
    private StandingService standingService;

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

}
