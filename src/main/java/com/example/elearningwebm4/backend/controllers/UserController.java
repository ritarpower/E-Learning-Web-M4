package com.example.elearningwebm4.backend.controllers;

import com.example.elearningwebm4.backend.common.EncryptPasswordUtils;
import com.example.elearningwebm4.backend.dto.UsersDto;
import com.example.elearningwebm4.backend.models.Role;
import com.example.elearningwebm4.backend.models.Users;
import com.example.elearningwebm4.backend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping("user/profile")
    public String showProfile(Model model,
                              @AuthenticationPrincipal UserDetails userDetails) {
        Users user = usersService.findByEmail(userDetails.getUsername());
        model.addAttribute("user", user);
        return "user/profile-page";
    }

    @GetMapping("user/change-password-page")
    public String showChangePasswordPage(Model model) {
        UsersDto userDto = new UsersDto();
        model.addAttribute("userDto", userDto);
        return "user/change-password-page";
    }

    @PostMapping("user/change-password")
    public String changePassword(@AuthenticationPrincipal UserDetails userDetails,
                                 @ModelAttribute("userDto") UsersDto userDto,
                                 RedirectAttributes redirectAttributes) {
        Users user = usersService.findByEmail(userDetails.getUsername());
        if (EncryptPasswordUtils.CheckPassword(userDto.getOldPassword(), user.getPassword())) {
            if (userDto.getPassword().equals(userDto.getConfirmPassword())) {
                user.setPassword(EncryptPasswordUtils.EncryptPasswordUtils(userDto.getPassword()));
                usersService.saveUser(user);
                redirectAttributes.addFlashAttribute("message", "Thay đổi mật khẩu thành công");
                return "redirect:/user/profile";
            } else {
                redirectAttributes.addFlashAttribute("message", "Vui lòng nhập lại mật khẩu mới cho trùng khớp!");
                return "redirect:/user/change-password-page";
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "Mật khẩu hiện tại không đúng!");
            return "redirect:/user/change-password-page";
        }
    }

    @GetMapping("admin/user-list")
    public String showUserListPage(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                   Model model) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Users> usersList = usersService.findAllUsers(pageable);
        model.addAttribute("usersList", usersList);
        return "user/user-list";
    }

    @GetMapping("admin/search-user")
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

    @GetMapping("admin/user-list/{id}")
    public String showUserDetailPage(@PathVariable(name = "id") Long userId, Model model) {
        Users user = usersService.findByUserId(userId);
        String roles = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.joining(", "));
        model.addAttribute("roleList", roles);
        model.addAttribute("user", user);
        return "user/user-detail-page";
    }

//    @PostMapping("/admin/{id}/delete-user")
//    public String deleteUser(@PathVariable(name = "id") Long userId,
//                             RedirectAttributes redirectAttributes) {
//        usersService.deleteUserById(userId);
//        redirectAttributes.addFlashAttribute("message", "Đã xoá thành công người dùng!");
//        return "redirect:/admin/user-list";
//    }

    @PostMapping("/admin/{id}/change-status")
    public String changeStatusUser(@PathVariable(name = "id") Long userId,
                                   RedirectAttributes redirectAttributes) {
        usersService.changeStatusUserById(userId);
        redirectAttributes.addFlashAttribute("message", "Đã thay đổi thành công trạng thái!");
        return "redirect:/admin/user-list";
    }
}