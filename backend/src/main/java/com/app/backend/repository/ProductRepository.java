package com.app.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.backend.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
    Boolean existsByPrice(Double price);
    List<Product> findBySubcategoryId(Long subcategoryId);
    List<Product> findByCategoryId(Long categoryId);
    Boolean existsByStock(Integer stock);
}
