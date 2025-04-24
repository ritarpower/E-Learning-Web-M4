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
    private ICartRepository cartRepository;

    @Autowired
    private IUsersRepository usersRepository;

    @Autowired
    private ICoursesRepository coursesRepository;

    @Autowired
    private IEnrollments enrollmentsRepository;

    @Override
    public Cart getActiveCart(Long userId) {
        return cartRepository.findByUserUserIdAndStatus(userId, "ACTIVE")
                .orElseGet(() -> createCart(userId));
    }

    @Override
    public Cart createCart(Long userId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng!"));

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setItems(List.of());
        cart.setStatus("ACTIVE");
        return cartRepository.save(cart);
    }

    @Override
    @Transactional
    public Cart addCourseToCart(Long userId, Long courseId) {
        Cart cart = getActiveCart(userId);
        Courses course = coursesRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học!"));

        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getCourse().getCourseId().equals(courseId))
                .findFirst();

        if (existingItem.isPresent()) {
            throw new RuntimeException("Khóa học đã có trong giỏ hàng!");
        }

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setCourse(course);
        item.setQuantity(1);

        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @Override
    @Transactional
    public Cart removeCourseFromCart(Long userId, Long courseId) {
        Cart cart = getActiveCart(userId);

        cart.getItems().removeIf(item -> item.getCourse().getCourseId().equals(courseId));
        return cartRepository.save(cart);
    }

    @Override
    @Transactional
    public Cart checkout(Long userId) {
        Cart cart = cartRepository.findByUserUserIdAndStatus(userId, "ACTIVE")
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giỏ hàng!"));

        for (CartItem item : cart.getItems()) {
            Enrollments enrollment = new Enrollments();
            enrollment.setUser(cart.getUser());
            enrollment.setCourse(item.getCourse());
            enrollment.setEnrolledAt(LocalDateTime.now());
            enrollmentsRepository.save(enrollment);
        }

        cart.setStatus("COMPLETED");
        return cartRepository.save(cart);
    }
}
