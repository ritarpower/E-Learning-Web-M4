//package com.example.elearningwebm4.backend.controllers;
//
//import com.example.elearningwebm4.backend.models.Cart;
//import com.example.elearningwebm4.backend.models.Users;
//import com.example.elearningwebm4.backend.services.CartService;
//import com.example.elearningwebm4.backend.services.UsersService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//@ControllerAdvice
//public class GlobalControllerAdvice {
//    @Autowired
//    private UsersService userService;
//
//    @Autowired
//    private CartService cartService;
//
//    @ModelAttribute("itemsCount")
//    public int getItemsCount(@AuthenticationPrincipal UserDetails userDetails) {
//        if (userDetails != null) {
//            try {
//                Users user = userService.findByEmail(userDetails.getUsername());
//                if (user != null) {
//                    Cart cart = cartService.findByUserId(user.getUserId());
//                    if (cart != null && cart.getItems() != null) {
//                        return cart.getItems().size();
//                    }
//                }
//            } catch (Exception e) {
//                // Ghi log lỗi nếu có bất kỳ vấn đề gì trong quá trình lấy dữ liệu
//                e.printStackTrace();
//            }
//        }
//        return 0;
//    }
//}
