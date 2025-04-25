package com.example.elearningwebm4.backend.controllers;

import com.example.elearningwebm4.backend.common.EncryptPasswordUtils;
import com.example.elearningwebm4.backend.dto.UsersDto;
import com.example.elearningwebm4.backend.models.Role;
import com.example.elearningwebm4.backend.models.Users;
import com.example.elearningwebm4.backend.repositories.IRoleRepository;
import com.example.elearningwebm4.backend.repositories.IUsersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private IUsersRepository usersRepository;

    @GetMapping
    public String registrationForm(Model model){
        model.addAttribute("userDto", new UsersDto());
        return "security/registration";
    }

    @PostMapping("/regis")
    public String registrationSubmit(@ModelAttribute("userDto") UsersDto userDto,
                                     RedirectAttributes redirectAttributes,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "security/registration";
        }
        if(usersRepository.findByEmail(userDto.getEmail()) == null){
            if (userDto.getPassword().equals(userDto.getConfirmPassword())) {
                Users user = new Users();
                user.setName(userDto.getName());
                user.setEmail(userDto.getEmail());
                user.setPassword(EncryptPasswordUtils.EncryptPasswordUtils(userDto.getPassword()));
                user.setStatus(true);
                List<Role> roles = new ArrayList<>();
                roles.add(roleRepository.findByName("ROLE_USER"));
                user.setRoles(roles);
                usersRepository.save(user);
                redirectAttributes.addFlashAttribute("message", "Tạo mới tài khoản thành công!");
                return "redirect:/login";
            } else {
                redirectAttributes.addFlashAttribute("message", "Mật khẩu không khớp, vui lòng đăng ký lại!");
                return "redirect:/registration";
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "Email đã được đăng ký, vui lòng dăng ký lại!");
            return "redirect:/registration";
        }
    }
}
