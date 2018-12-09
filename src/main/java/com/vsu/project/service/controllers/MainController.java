package com.vsu.project.service.controllers;

import com.vsu.project.service.entity.News;
import com.vsu.project.service.entity.User;
import com.vsu.project.service.entity.enums.UserRole;
import com.vsu.project.service.services.impl.NewsServiceImpl;
import com.vsu.project.service.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("")
public class MainController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private NewsServiceImpl newsService;

    @GetMapping("/user/{id}")
    public String userProfile(@RequestParam long id, ModelMap modelMap){
        User user = userService.findByUsername("");
        return "index";
    }

    @GetMapping("/")
    public String index(ModelMap modelMap){
        List<User> users = userService.getUsersByRole(UserRole.User);
        List<News> news = newsService.getAll(5);
        modelMap.addAttribute("users", users);
        modelMap.addAttribute("news", news);
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
