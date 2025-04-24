package com.example.elearningwebm4.backend.controllers;

import com.example.elearningwebm4.backend.models.Cart;
import com.example.elearningwebm4.backend.models.CartItem;
import com.example.elearningwebm4.backend.models.Users;
import com.example.elearningwebm4.backend.services.CartService;
import com.example.elearningwebm4.backend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public String addCourseToCart(@RequestParam Long userId, @RequestParam Long courseId, RedirectAttributes redirectAttributes) {
        cartService.addCourseToCart(userId, courseId);
        redirectAttributes.addFlashAttribute("message", "Khoá học đã được thêm vào giỏ hàng");
        return "redirect:/cart/items?userId=" + userId;
    }

    @GetMapping("/items")
    public String getCartItems(@RequestParam Long userId, Model model) {
        List<CartItem> items = cartService.getCartItems(userId);
        model.addAttribute("items", items);
        model.addAttribute("userId", userId);
        return "cart/items";
    }

    @PostMapping("/remove")
    public String removeCourseFromCart(@RequestParam Long userId, @RequestParam Long courseId, RedirectAttributes redirectAttributes) {
        cartService.removeCourseFromCart(userId, courseId);
        redirectAttributes.addFlashAttribute("message", "Khoá học đã được xoá khỏi giỏ hàng");
        return "redirect:/cart/items?userId=" + userId;
    }

    @PostMapping("/checkout")
    public String checkout(@RequestParam Long userId, RedirectAttributes redirectAttributes) {
        cartService.checkout(userId);
        redirectAttributes.addFlashAttribute("message", "Đăng ký thành công!");
        return "redirect:/cart/items?userId=" + userId;
    }
}
