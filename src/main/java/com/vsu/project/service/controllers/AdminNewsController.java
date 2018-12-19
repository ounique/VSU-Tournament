package com.vsu.project.service.controllers;

import com.vsu.project.service.entity.News;
import com.vsu.project.service.entity.User;
import com.vsu.project.service.services.DepartmentService;
import com.vsu.project.service.services.NewsService;
import com.vsu.project.service.services.UserService;
import com.vsu.project.service.utils.Updater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminNewsController {

    private UserService userService;
    private NewsService newsService;
    private Updater updater;

    @Autowired
    AdminNewsController(UserService userService,
                    NewsService newsService,
                    Updater updater){
        this.userService = userService;
        this.newsService = newsService;
        this.updater = updater;
    }

    @GetMapping("/news")
    public String getAllNews(ModelMap modelMap){
        modelMap.addAttribute("news", newsService.getAll());
        return "admin/admin-news";
    }

    @GetMapping("/news/edit/{id}")
    public String editNewspaper(@PathVariable long id, ModelMap modelMap){
        modelMap.addAttribute("news", newsService.getById(id));
        return "admin/admin-edit-news";
    }

    @GetMapping("/news/add")
    public String addNews(ModelMap modelMap){
        return "admin/admin-add-news";
    }

    @PostMapping(value = "/news/add", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addNews(@RequestBody MultiValueMap<String, String> map, ModelMap modelMap){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername());
        News news =  new News();
        news = updater.updateNews(news, map, user);
        newsService.addNews(news);
        modelMap.addAttribute("alertMessage", "Новость успешно создана !");
        modelMap.addAttribute("news", newsService.getAll());
        return "admin/admin-news";
    }

    @PostMapping(value = "/news/update/{id}", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateNews(@PathVariable long id, @RequestBody MultiValueMap<String, String> map, ModelMap modelMap){
        News news =  newsService.getById(id);
        news = updater.updateNews(news, map, news.getUser());
        newsService.updateNews(news);
        modelMap.addAttribute("alertMessage", "Новость успешно обновлена !");
        modelMap.addAttribute("news", newsService.getAll());
        return "admin/admin-news";
    }

    @PostMapping(value = "/news/delete/{id}", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String deleteNews(@PathVariable long id, ModelMap modelMap){
        newsService.delete(id);
        modelMap.addAttribute("alertMessage", "Новость успешно удалена !");
        modelMap.addAttribute("news", newsService.getAll());
        return "admin/admin-news";
    }

}
