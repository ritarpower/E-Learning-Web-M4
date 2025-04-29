package com.example.elearningwebm4.backend.controllers;

import com.example.elearningwebm4.backend.models.Users;
import com.example.elearningwebm4.backend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping("profile")
    public String showProfile(Model model) {
        return "user/user-page";
    }

    @GetMapping("/admin/user-list")
    public String showUserListPage(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                   Model model) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Users> usersList = usersService.findAllUsers(pageable);
        model.addAttribute("usersList", usersList);
        return "user/user-list";
    }

    @GetMapping("search-user")
    public String searchUser(@RequestParam(name = "search") String name,
                             @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                             Model model) {
        Pageable pageable = PageRequest.of(page, 20);
        if (name.trim().isEmpty()) {
            Page<Users> usersList = usersService.findAllUsers(pageable);
            model.addAttribute("usersList", usersList);
        } else {
            Page<Users> usersList = usersService.findByNameContaining(name, pageable);
            model.addAttribute("usersList", usersList);
        }
        return "user/user-list";
    }

    @PostMapping("{id}/delete-user")
    public String deleteUser(@PathVariable(name = "id") Long userId,
                             RedirectAttributes redirectAttributes) {
        usersService.deleteUserById(userId);
        redirectAttributes.addFlashAttribute("message", "Đã xoá thành công người dùng!");
        return "redirect:/admin/user-list";
    }

    @PostMapping("{id}/change-status")
    public String changeStatusUser(@PathVariable(name = "id") Long userId,
                                   RedirectAttributes redirectAttributes) {
        usersService.changeStatusUserById(userId);
        redirectAttributes.addFlashAttribute("message", "Đã thay đổi thành công trạng thái!");
        return "redirect:/admin/user-list";
    }
}
