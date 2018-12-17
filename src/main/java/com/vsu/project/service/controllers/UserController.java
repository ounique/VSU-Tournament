package com.vsu.project.service.controllers;

import com.vsu.project.service.entity.News;
import com.vsu.project.service.entity.User;
import com.vsu.project.service.entity.enums.UserRole;
import com.vsu.project.service.exceptions.AccessDeniedException;
import com.vsu.project.service.exceptions.UsernameAlreadyExistsException;
import com.vsu.project.service.services.NewsService;
import com.vsu.project.service.services.UserService;
import com.vsu.project.service.services.impl.NewsServiceImpl;
import com.vsu.project.service.services.impl.UserServiceImpl;
import com.vsu.project.service.utils.Updater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {

    private UserService userService;
    private NewsService newsService;
    private Updater updater;

    @Autowired
    UserController(NewsService newsService,
                   UserService userService,
                   Updater updater){
        this.userService = userService;
        this.newsService = newsService;
        this.updater = updater;
    }

    @GetMapping("/")
    public String index(@RequestParam(value = "errorMessage", required = false) String error,
                        ModelMap modelMap,
                        Principal principal){
        List<User> users = userService.getUsersByRole(UserRole.User);
        List<News> news = newsService.getAll(5);
        modelMap.addAttribute("users", users);
        modelMap.addAttribute("news", news);
        if (error != null){
            modelMap.addAttribute("errorMessage", error);
        }
        if (principal != null){
            modelMap.addAttribute("user", userService.findByUsername(principal.getName()));
        }
        return "index";
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String deniedAccessToPage(){
        return "redirect:?errorMessage=Нельзя редактировать чужой профиль !";
    }

    @GetMapping("/login")
    public ModelAndView failLogin(@RequestParam(value = "error", required = false) String error,
                                  ModelMap modelMap){
        modelMap.addAttribute("errorMessage", "Неправильный логин или пароль ! Попробуйте снова !");
        return new ModelAndView("redirect:/", modelMap);
    }

    @GetMapping("/profile/{id}")
    public String failLogin(@PathVariable("id") long userId,
                                  ModelMap modelMap,
                                  Principal principal){
        User user = userService.getById(userId);
        modelMap.addAttribute("isUserProfile", user.getUsername().equals(principal.getName()));
        modelMap.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/profile/{id}/edit")
    public String editProfile(@PathVariable long id,
                              ModelMap modelMap,
                              Principal principal){
        User user = userService.findByUsername(principal.getName());
        if (user.getId() == id) {
            modelMap.addAttribute("user", user);
            return "profile-edit";
        } else
            throw new AccessDeniedException("Нельзя редактировать чужой профиль");
    }

    @PostMapping(value = "/profile/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateUserInfo(@RequestBody MultiValueMap<String, String> map,
                                 ModelMap modelMap){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername());
        user = updater.updateUser(user, map);
        user = userService.updateUser(user);
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("isUserProfile", true);
        return "profile";
    }

}
