package com.example.elearningwebm4.backend.controllers;

import com.example.elearningwebm4.backend.models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class Registration {
    @GetMapping
    public String registrationForm(Model model){
        model.addAttribute("user", new Users());
        return "security/registration";
    }
}
