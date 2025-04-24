package com.example.elearningwebm4.backend.repositories;

import com.example.elearningwebm4.backend.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserId(Long userId);
}