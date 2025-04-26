package com.example.elearningwebm4.backend.repositories;

import com.example.elearningwebm4.backend.models.Cart;
import com.example.elearningwebm4.backend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICartRepository extends JpaRepository<Cart, Long> {
    @Query("SELECT c FROM Cart c WHERE c.user.userId = :userId")
    Cart findByUserId(@Param("userId") Long userId);
}
