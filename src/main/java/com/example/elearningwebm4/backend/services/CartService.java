package com.example.elearningwebm4.backend.services;


import com.example.elearningwebm4.backend.models.Cart;
import com.example.elearningwebm4.backend.models.CartItem;

import java.util.List;

public interface CartService {
    void addCourseToCart(Long userId, Long courseId);
    void removeCourseFromCart(Long userId, Long courseId);
    void checkout(Long userId);
    List<CartItem> getCartItems(Long userId);
}
