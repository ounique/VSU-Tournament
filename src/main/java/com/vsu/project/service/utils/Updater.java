package com.vsu.project.service.utils;

import com.vsu.project.service.entity.User;
import com.vsu.project.service.entity.enums.UserRole;
import com.vsu.project.service.exceptions.UsernameAlreadyExistsException;
import com.vsu.project.service.repository.UserRepository;
import com.vsu.project.service.services.DepartmentService;
import com.vsu.project.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

@Component
public class Updater {

    private DepartmentService departmentService;
    private BCryptPasswordEncoder passwordEncoder;
    private static final String URL_DEFAULT_PICTURE = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxO_i_Va1kmSnEuc79-CAgLhmmnyaSIBjeqXqhsuD3tpyFSD7Q";
    private UserRepository userRepository;

    @Autowired
    Updater(DepartmentService departmentService,
            UserRepository userRepository){
        this.userRepository = userRepository;
        this.departmentService = departmentService;
        passwordEncoder = new BCryptPasswordEncoder();
    }

    public User updateUser(User user, MultiValueMap<String, String> params){
        params.forEach((k, v)->{
            switch (k){
                case "department":
                    user.setDepartment(
                            departmentService.getById(
                                    Long.parseLong(params.getFirst(k))
                            )
                    );
                    break;
                case "firstName":
                    user.setFirstName(params.getFirst(k));
                    break;
                case "secondName":
                    user.setSecondName(params.getFirst(k));
                    break;
                case "password":
                    user.setPassword(passwordEncoder.encode(params.getFirst(k)));
                    break;
                case "studentBookId":
                    user.setStudentBookId(Long.parseLong(params.getFirst(k)));
                    break;
                case "description":
                    user.setDescription(params.getFirst(k));
                    break;
                case "picture":
                    user.setPicture(params.getFirst(k));
                    break;
                case "linkVK":
                    user.setLinkVK(params.getFirst(k));
                    break;
                case "linkFB":
                    user.setLinkFB(params.getFirst(k));
                    break;
                case "linkINS":
                    user.setLinkINS(params.getFirst(k));
                    break;
                case "linkTWI":
                    user.setLinkTWI(params.getFirst(k));
                    break;
                case "username":
                    String username = params.getFirst(k);
                    if (userRepository.findByUsername(username) != null)
                        throw new UsernameAlreadyExistsException(username);
                    user.setUsername(username);
                    break;
                case "role":
                    user.setRole(UserRole.valueOf(params.getFirst(k)));
                    break;
            }
        });
        if (user.getPicture() == null){
            user.setPicture(URL_DEFAULT_PICTURE);
        }
        return user;
    }
}
