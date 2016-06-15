package ru.kpfu.itis.group408.marushkai.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by unlim_000 on 06.04.2016.
 */

@Controller
@RequestMapping("/static")
public class StaticController {

    @RequestMapping("/international")
    public String showInternational() {
        return "International";
    }

    @RequestMapping("/reg")
    public String register() {
        return "Registration";
    }

}
