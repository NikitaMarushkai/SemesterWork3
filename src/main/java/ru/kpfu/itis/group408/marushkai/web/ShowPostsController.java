package ru.kpfu.itis.group408.marushkai.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.group408.marushkai.domain.Contestant;
import ru.kpfu.itis.group408.marushkai.domain.Post;
import ru.kpfu.itis.group408.marushkai.domain.Team;
import ru.kpfu.itis.group408.marushkai.service.interfaces.ContestantService;
import ru.kpfu.itis.group408.marushkai.service.interfaces.PostService;
import ru.kpfu.itis.group408.marushkai.service.interfaces.TeamService;

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

    @RequestMapping("/news")
    public String showNews(Map<String, Object> map) {
        ArrayList<Post> posts = (ArrayList<Post>) postService.listContestants();
        map.put("news", posts);
        return "News";
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
