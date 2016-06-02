package ru.kpfu.itis.group408.marushkai.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kpfu.itis.group408.marushkai.domain.Contestant;
import ru.kpfu.itis.group408.marushkai.domain.Post;
import ru.kpfu.itis.group408.marushkai.domain.Team;
import ru.kpfu.itis.group408.marushkai.domain.user.User;
import ru.kpfu.itis.group408.marushkai.service.interfaces.ContestantService;
import ru.kpfu.itis.group408.marushkai.service.interfaces.PostService;
import ru.kpfu.itis.group408.marushkai.service.interfaces.TeamService;
import ru.kpfu.itis.group408.marushkai.service.interfaces.UserService;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by unlim_000 on 30.03.2016.
 */
@Controller
public class ShowPostsController {

    @Autowired
    PostService<Post> postService;

    @Autowired
    ContestantService<Contestant> contestantService;

    @Autowired
    TeamService<Team> teamService;

    @Autowired
    UserService userService;


    @RequestMapping("/showNews")
    public String showNews(Map<String, Object> map) {
        ArrayList<Post> posts = (ArrayList<Post>) postService.listContestants();
        map.put("news", posts);
        return "News";
    }

    @RequestMapping("/openNewsTab")
    public String openNews(Map<String, Object> map, @RequestParam("id") Integer postId) {
        try {
            map.put("post", postService.getById(postId));
        } catch (Exception e) {
            map.put("error", "Ошибка в получении новости (внутренняя ошибка сервера)");
        }
        return "OnePost";
    }

    @RequestMapping("/addComment")
    @ResponseStatus(value = HttpStatus.OK)
    public void addComment(Map<String, Object> map, @RequestParam Integer postID,
                           @RequestParam String text) {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        postService.addComment(postID, text, user);
        //return "redirect:/openNewsTab?id=" + postID;//???
    }


    @RequestMapping("/timeTable")
    public String showTimeTable(Map<String, Object> map) {
        map.put("east", contestantService.listEastSide());
        map.put("west", contestantService.listWestSide());
        return "TimeTable";
    }

    @RequestMapping("/teamList")
    public String showTeamList(Map<String, Object> map) {
        map.put("teams", teamService.listContestants());
        return "TeamList";
    }
}
