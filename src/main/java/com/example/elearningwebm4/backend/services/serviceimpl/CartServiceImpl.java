package com.example.elearningwebm4.backend.services.serviceimpl;

import com.example.elearningwebm4.backend.models.*;
import com.example.elearningwebm4.backend.repositories.*;
import com.example.elearningwebm4.backend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private IUsersRepository usersRepository;

    @Autowired
    private ICoursesRepository coursesRepository;

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private ICartItemRepository cartItemRepository;

    @Override
    public void addCourseToCart(Long userId, Long courseId) {
        Users user = usersRepository.findById(userId).get();
        Courses course = coursesRepository.findById(courseId).get();
        Cart cart = user.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
            user.setCart(cart);
        }

        boolean alreadyExists = cart.getItems().stream()
                .anyMatch(item -> item.getCourse().getCourseId().equals(courseId));

        if (alreadyExists) {
            throw new RuntimeException("Course already in cart");
        }

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setCourse(course);
        cart.getItems().add(item);
        cartRepository.save(cart);
    }

    @Override
    public void removeCourseFromCart(Long userId, Long courseId) {

    }

    @Override
    public void checkout(Long userId) {

    }

    @Override
    public List<CartItem> getCartItems(Long userId) {
        return List.of();
    }
}
