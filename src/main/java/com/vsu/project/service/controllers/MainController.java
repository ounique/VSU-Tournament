package com.vsu.project.service.controllers;

import com.vsu.project.service.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {

    @GetMapping("")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("user", new User("Eugene", 2));
        return "index";
    }

}
