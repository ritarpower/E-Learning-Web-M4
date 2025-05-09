package com.example.elearningwebm4.backend.services;

import com.example.elearningwebm4.backend.models.CartItem;

import java.util.List;

public interface CartItemService {
    void addCourseToCart(Long cartId, Long courseId);
    void removeCartItem(Long cartItemId);
}