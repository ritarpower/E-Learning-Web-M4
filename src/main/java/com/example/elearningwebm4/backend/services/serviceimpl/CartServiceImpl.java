package com.example.elearningwebm4.backend.services.serviceimpl;


import com.example.elearningwebm4.backend.models.*;
import com.example.elearningwebm4.backend.repositories.ICartRepository;
import com.example.elearningwebm4.backend.repositories.IEnrollmentsRepository;
import com.example.elearningwebm4.backend.services.CartService;
import com.example.elearningwebm4.backend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private IEnrollmentsRepository enrollmentsRepository;

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private UsersService usersService;

    @Override
    public Cart findByUserId(Long userId) {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            cart = new Cart();
            cart.setUser(usersService.findByUserId(userId));
            cart.setItems(new ArrayList<>());
            cartRepository.save(cart);
            return cart;
        }
        return cart;
    }

    @Override
    @Transactional
    public void payCart(Long userId) {
        Cart cart = findByUserId(userId);
        Users user = cart.getUser();
        for (CartItem item : cart.getItems()) {
            Courses course = item.getCourse();
            boolean alreadyEnrolled = enrollmentsRepository.existsByCourseAndUser(course, user);
            if (alreadyEnrolled) {
                continue;
            }
            Enrollments enrollments = new Enrollments();
            enrollments.setUser(user);
            enrollments.setCourse(course);
            enrollmentsRepository.save(enrollments);
        }
        cart.getItems().clear();
        cartRepository.save(cart);
    }
}
