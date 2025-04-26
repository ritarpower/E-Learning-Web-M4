package com.example.elearningwebm4.backend.services;


import com.example.elearningwebm4.backend.models.Cart;


public interface CartService {
    Cart findByUserId(Long userId);
    void payCart(Long userId);
}
