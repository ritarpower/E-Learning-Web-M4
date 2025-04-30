package com.example.elearningwebm4.backend.services.serviceimpl;

import com.example.elearningwebm4.backend.models.Cart;
import com.example.elearningwebm4.backend.models.CartItem;
import com.example.elearningwebm4.backend.models.Courses;
import com.example.elearningwebm4.backend.repositories.ICartItemRepository;
import com.example.elearningwebm4.backend.repositories.ICartRepository;
import com.example.elearningwebm4.backend.repositories.ICoursesRepository;
import com.example.elearningwebm4.backend.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private ICartItemRepository cartItemRepository;

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private ICoursesRepository coursesRepository;

    @Override
    public void addCourseToCart(Long cartId, Long courseId) {
        if(cartItemRepository.existsByCart_CartIdAndCourse_CourseId(cartId, courseId)) {
            throw new RuntimeException("Course already in cart");
        }
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Không tìm thấy giỏ hàng"));

        Courses courses = coursesRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học"));

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setCourse(courses);
        cartItemRepository.save(cartItem);
    }

    @Override
    public void removeCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

}
