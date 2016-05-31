package ru.kpfu.itis.group408.marushkai.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.group408.marushkai.domain.Post;
import ru.kpfu.itis.group408.marushkai.form.AddNewsForm;
import ru.kpfu.itis.group408.marushkai.form.UpdateNewsForm;
import ru.kpfu.itis.group408.marushkai.service.interfaces.PostService;


/**
 * Created by unlim_000 on 30.03.2016.
 */

@Controller
@RequestMapping(value = "/admin")
public class AdministrativeController {

    @Autowired
    PostService<Post> postService;


    @RequestMapping(value = "/addPost/news")
    public String addOrDeletePost(/*@PathVariable("category") String category, @RequestParam(name = "head") String head,*/@ModelAttribute AddNewsForm newsForm) {
//        switch (category) {
//            case "news":
        postService.add(newsForm);
        return "admin";
//            case "delete":
//                try {
////                    postService.deleteById(id);
//                } catch (Exception e) {
////                    map.put("alert", "Impossible to delete by ID, ID is missing");
//                }
//                return "redirect:/news";
//        }
//        return "admin";
    }

    @RequestMapping(value = "/editForm")
    public String editPost(@ModelAttribute UpdateNewsForm updateNewsForm) {
        postService.update(updateNewsForm);
        return "admin";
    }

//    @RequestMapping(value = "admin/addPost/news", method = RequestMethod.GET)
//    public String showAddNewsAdmin(){
//        return "admin";
//    }


}
