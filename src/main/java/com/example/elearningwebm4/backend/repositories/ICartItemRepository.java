package com.example.elearningwebm4.backend.repositories;

import com.example.elearningwebm4.backend.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartItemRepository extends JpaRepository<CartItem, Long> {
}
