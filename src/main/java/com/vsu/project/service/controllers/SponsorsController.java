package com.vsu.project.service.controllers;

import com.vsu.project.service.entity.enums.UserRole;
import com.vsu.project.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/sponsors")
public class SponsorsController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String sponsorsPage(ModelMap modelMap, Principal principal){
        if (principal != null){
            modelMap.addAttribute("user", userService.findByUsername(principal.getName()));
        }
        modelMap.addAttribute("sponsors", userService.getUsersByRole(UserRole.Sponsor));
        return "sponsors";
    }

}
