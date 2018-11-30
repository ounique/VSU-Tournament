package com.vsu.project.service.configurations;

import com.vsu.project.service.controllers.ErrorController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class ErrorConfiguration {
    @Autowired
    private ErrorAttributes errorAttributes;

    @Bean
    public ErrorController errorController(){
        return new ErrorController(errorAttributes);
    }
}
