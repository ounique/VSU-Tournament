package com.vsu.project.service.controllers;

import com.vsu.project.service.entity.User;
import com.vsu.project.service.entity.enums.UserRole;
import com.vsu.project.service.services.DepartmentService;
import com.vsu.project.service.services.UserService;
import com.vsu.project.service.utils.Updater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private DepartmentService departmentService;
    private Updater updater;

    @Autowired
    AdminController(UserService userService,
                    DepartmentService departmentService,
                    Updater updater){
        this.userService = userService;
        this.departmentService = departmentService;
        this.updater = updater;
    }

    @GetMapping("")
    public String welcome(ModelMap modelMap, Principal principal){
        modelMap.addAttribute("adminName", principal.getName());
        return "admin/admin-index";
    }

}
