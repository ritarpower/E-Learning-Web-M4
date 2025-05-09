package com.example.elearningwebm4.backend.controllers;

import com.example.elearningwebm4.backend.models.Cart;
import com.example.elearningwebm4.backend.models.CartItem;
import com.example.elearningwebm4.backend.models.Users;
import com.example.elearningwebm4.backend.services.CartItemService;
import com.example.elearningwebm4.backend.services.CartService;
import com.example.elearningwebm4.backend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        if (userDetails == null) {
            return "redirect:/login";
        }
        Users user = usersService.findByEmail(userDetails.getUsername());
        Cart cart = cartService.findByUserId(user.getUserId());
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
                            @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return "redirect:/login";
        }
        Users user = usersService.findByEmail(userDetails.getUsername());
        Cart cart = cartService.findByUserId(user.getUserId());
        try {
            cartItemService.addCourseToCart(cart.getCartId(), courseId);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Khóa học đã có trong giỏ hàng!");
            return "redirect:/";
        }
        return "redirect:/";
    }

    @PostMapping("/remove-cart-item")
    public String removeCartItemFromCart(@RequestParam(name = "cartItemId") Long cartItemId,
                                         @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return "redirect:/login";
        }
        cartItemService.removeCartItem(cartItemId);
        return "redirect:/cart/cart-view";
    }

    @PostMapping("/payment")
    public String payCart(RedirectAttributes redirectAttributes,
                          @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return "redirect:/login";
        }
        Users user = usersService.findByEmail(userDetails.getUsername());
        cartService.payCart(user.getUserId());
        redirectAttributes.addFlashAttribute("message", "Thanh toán thành công giỏ hàng!");
        return "redirect:/";
    }
}