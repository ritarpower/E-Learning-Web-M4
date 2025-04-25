package com.example.elearningwebm4.backend.repositories;

import com.example.elearningwebm4.backend.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartItemRepository extends JpaRepository<CartItem, Long> {

    @Query("SELECT c.items FROM Cart c WHERE c.cartId = :cartId")
    List<CartItem> findByCart_CartId(@Param("cartId") Long cartId);

    boolean existsByCart_CartIdAndCourse_CourseId(Long cartId, Long courseId);

    CartItem findByCart_CartIdAndCourse_CourseId(Long cartId, Long courseId);
}
