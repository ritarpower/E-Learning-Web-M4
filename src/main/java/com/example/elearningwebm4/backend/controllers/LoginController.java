package com.example.elearningwebm4.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/login")
@Controller
public class LoginController {

    @GetMapping
    public String loginForm(){
        return "security/login";
    }

}
