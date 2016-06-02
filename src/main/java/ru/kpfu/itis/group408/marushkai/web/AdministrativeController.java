package ru.kpfu.itis.group408.marushkai.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.group408.marushkai.domain.Post;
import ru.kpfu.itis.group408.marushkai.domain.Standing;
import ru.kpfu.itis.group408.marushkai.form.AddAdvertForm;
import ru.kpfu.itis.group408.marushkai.form.AddNewsForm;
import ru.kpfu.itis.group408.marushkai.form.EditTableForm;
import ru.kpfu.itis.group408.marushkai.form.UpdateNewsForm;
import ru.kpfu.itis.group408.marushkai.service.interfaces.AdvertService;
import ru.kpfu.itis.group408.marushkai.service.interfaces.PostService;
import ru.kpfu.itis.group408.marushkai.service.interfaces.StandingService;


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


    @RequestMapping(value = "/addPost/news")
    public String addOrDeletePost(/*@PathVariable("category") String category, @RequestParam(name = "head") String head,*/@ModelAttribute AddNewsForm newsForm) {
        postService.add(newsForm);
        return "admin";
    }

    @RequestMapping(value = "/editForm")
    public String editPost(@ModelAttribute UpdateNewsForm updateNewsForm) {
        postService.update(updateNewsForm);
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

}
