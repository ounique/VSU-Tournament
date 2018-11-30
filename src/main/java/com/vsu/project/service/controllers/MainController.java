package com.vsu.project.service.controllers;

import com.vsu.project.service.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class MainController {

    @GetMapping("/user/{id}")
    public String userProfile(@RequestParam long id, ModelMap modelMap){
        return "index";
    }

}
