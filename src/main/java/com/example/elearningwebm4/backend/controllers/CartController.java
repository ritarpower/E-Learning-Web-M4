package com.example.elearningwebm4.backend.controllers;

import com.example.elearningwebm4.backend.models.Cart;
import com.example.elearningwebm4.backend.services.CartService;
import com.example.elearningwebm4.backend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/{userId}")
    public String viewCart(@PathVariable("userId") Long userId, Model model) {
        Cart cart = cartService.getActiveCart(userId);
        model.addAttribute("cart", cart);
        return "cart/cart-view";
    }

    @PostMapping("/add-item")
    public String addCourseToCart(@RequestParam("userId") Long userId,
                                  @RequestParam("courseId") Long courseId,
                                  Model model) {
        try {
            cartService.addCourseToCart(userId, courseId);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "redirect:/cart/cart-view" + userId;
    }

    @PostMapping("/remove-item")
    public String removeCourseFromCart(@RequestParam("userId") Long userId,
                                       @RequestParam("courseId") Long courseId) {
        cartService.removeCourseFromCart(userId, courseId);
        return "redirect:/cart/cart-view" + userId;
    }

    @PostMapping("/checkout")
    public String checkout(@RequestParam("userId") Long userId, Model model) {
        try {
            cartService.checkout(userId);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "redirect:/cart/cart-view" + userId;
    }
}
