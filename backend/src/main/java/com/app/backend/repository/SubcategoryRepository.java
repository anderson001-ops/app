package com.app.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.backend.models.Subcategory;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    Optional<Subcategory> findByName(String name);
    Boolean existsByName(String name);
    List<Subcategory> findByCategoryId(Long categoryId);
}
