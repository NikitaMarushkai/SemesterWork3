package ru.kpfu.itis.group408.marushkai.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.group408.marushkai.domain.Contestant;
import ru.kpfu.itis.group408.marushkai.domain.Post;
import ru.kpfu.itis.group408.marushkai.domain.Standing;
import ru.kpfu.itis.group408.marushkai.form.*;
import ru.kpfu.itis.group408.marushkai.service.interfaces.AdvertService;
import ru.kpfu.itis.group408.marushkai.service.interfaces.ContestantService;
import ru.kpfu.itis.group408.marushkai.service.interfaces.PostService;
import ru.kpfu.itis.group408.marushkai.service.interfaces.StandingService;

import java.util.Map;


/**
 * Created by unlim_000 on 30.03.2016.
 */

@Controller
@RequestMapping(value = "/admin")
public class AdministrativeController {

    @Autowired
    PostService<Post> postService;

    @Autowired
    StandingService<Standing> standingService;

    @Autowired
    AdvertService advertService;

    @Autowired
    ContestantService<Contestant> contestantService;


    @RequestMapping(value = "/addPost/news")
    public String addOrDeletePost(/*@PathVariable("category") String category, @RequestParam(name = "head") String head,*/@ModelAttribute AddNewsForm newsForm) {
        postService.add(newsForm);
        return "admin";
    }

    @RequestMapping(value = "/editForm")
    public String editPost(@ModelAttribute UpdateNewsForm updateNewsForm) {
        try {
            postService.update(updateNewsForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "admin";
    }

    @RequestMapping(value = "/editTable")
    public String editTable(@ModelAttribute EditTableForm editTableForm) {
        standingService.update(editTableForm);
        return "admin";
    }

    @RequestMapping(value = "/addAdvert")
    public String addAdvert(@ModelAttribute AddAdvertForm addAdvertForm) {
        if (addAdvertForm.getDelete() == 1) {
            advertService.delete(addAdvertForm.getListAdv());
        } else {
            advertService.add(addAdvertForm);
        }
        return "admin";
    }

    @RequestMapping(value = "/modifyTimeTable")
    public String modifyTimeTable(@ModelAttribute ModifyTimeTableForm form){
        if (form.getDeleteContest() == 1){
            try {
                contestantService.deleteById(form.getChooseContestToEdit());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            contestantService.add(new Contestant(form.getTeam1(), form.getTeam2(), form.getContestDate(),
                    form.getRegion()));
        }
        return "admin";
    }

    @RequestMapping(value = "/deleteComment", method = RequestMethod.GET)
    public String deleteComment(@RequestParam("id") Integer id, Map<String, Object> map){
        try {
            postService.deleteComment(id);
        } catch (Exception e) {
            map.put("err", "Ошибка в удалении комментария");
        }
        return "redirect:/showNews";
    }
}
