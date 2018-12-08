package com.vsu.project.service.controllers;

import com.vsu.project.service.entity.User;
import com.vsu.project.service.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("")
public class MainController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/user/{id}")
    public String userProfile(@RequestParam long id, ModelMap modelMap){
        User user = userService.findByUsername("");
        return "index";
    }

    @GetMapping("/")
    public String index(ModelMap model){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
