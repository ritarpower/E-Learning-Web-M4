package com.example.elearningwebm4.backend.controllers;

import com.example.elearningwebm4.backend.models.Cart;
import com.example.elearningwebm4.backend.models.CartItem;
import com.example.elearningwebm4.backend.models.Users;
import com.example.elearningwebm4.backend.services.CartItemService;
import com.example.elearningwebm4.backend.services.CartService;
import com.example.elearningwebm4.backend.services.UsersService;
import com.example.elearningwebm4.backend.services.serviceimpl.CustomUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.http.HttpRequest;

@Controller
@RequestMapping("/cart")
public class    CartController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/cart-view")
    public String cartView(Model model, @AuthenticationPrincipal UserDetails userDetails) {
//        Long userId = (Long) model.getAttribute("userId");
//        if (userId == null) {
//            return "redirect:/login";
//        }
        // HỎI ANH CÔNG LÀ DÙNG @AUTHEN VỚI TẠO 1 CONTROLLERGLOBAL THÌ CÁI NÀO OK HƠN
        Users users = usersService.findByEmail(userDetails.getUsername());
        if (userDetails == null) {
            return "redirect:/login";
        }
//        Cart cart = cartService.findByUserId(userId);
        Cart cart = cartService.findByUserId(users.getUserId());
        if (cart.getItems().isEmpty()) {
            return "cart/cart-view";
        }

        Double total = 0.0;
        for (CartItem item : cart.getItems()) {
            total += item.getCourse().getPrice();
        }
        model.addAttribute("total", total);
        model.addAttribute("items", cart.getItems());
        return "cart/cart-view";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam Long courseId,
                            RedirectAttributes redirectAttributes,
                            Model model) {
        Long userId = (Long) model.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        Cart cart = cartService.findByUserId(userId);
        try {
            cartItemService.addCourseToCart(cart.getCartId(), courseId);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Khóa học đã có trong giỏ hàng!");
            return "redirect:/";
        }

        return "redirect:/";
    }

    @PostMapping("/remove-cart-item")
    public String removeCartItem(@RequestParam(name = "courseId") Long courseId,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        Long userId = (Long) model.getAttribute("userId");
        Cart cart = cartService.findByUserId(userId);
        System.out.println(cart.getCartId());
        cartItemService.removeCartItem(cart.getCartId(), courseId);
        redirectAttributes.addFlashAttribute("mesage", "Đã xóa 1 khóa học khỏi giỏ hàng!");
        return "redirect:/cart/cart-view";
    }

    @PostMapping("/payment")
    public String payCart(RedirectAttributes redirectAttributes,
                          Model model) {
        Long userId = (Long) model.getAttribute("userId");
        cartService.payCart(userId);
        redirectAttributes.addFlashAttribute("message","Thanh toán thành công giỏ hàng!");
        return "redirect:/";
    }
}
