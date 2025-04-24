package com.example.elearningwebm4.backend.services;


import com.example.elearningwebm4.backend.models.Cart;

public interface CartService {
    Cart getActiveCart(Long userId);
    Cart createCart(Long userId);
    Cart addCourseToCart(Long userId, Long courseId);
    Cart removeCourseFromCart(Long userId, Long courseId);
    Cart checkout(Long userId);
}
