package com.example.elearningwebm4.backend.controllers;

import com.example.elearningwebm4.backend.models.Users;
import com.example.elearningwebm4.backend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UsersService usersService;


    @GetMapping("/user-list")
    public String showUserPage(@RequestParam(name = "search") String name,
                               @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                               Model model) {
        Pageable pageable = PageRequest.of(page, 20);
        if(name.trim().isEmpty()) {
            Page<Users> usersList = usersService.findAllUsers(pageable);
            model.addAttribute("usersList", usersList);
        } else {
            Page<Users> usersList= usersService.findByNameContaining(name, pageable);
            model.addAttribute("usersList", usersList);
        }
        return "user/user-list";
    }
}
