package com.example.elearningwebm4.backend.controllers;

import com.example.elearningwebm4.backend.models.Users;
import com.example.elearningwebm4.backend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {
    @Autowired
    private UsersService userService;

    @ModelAttribute
    public void addUserIdToModel(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            Users user = userService.findByEmail(userDetails.getUsername());
            model.addAttribute("userId", user.getUserId());
        }
    }
}
