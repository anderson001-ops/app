package com.app.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.backend.models.Category;
import com.app.backend.models.Subcategory;
import com.app.backend.repository.SubcategoryRepository;


@Service
public class SubCategoryService {
    
    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CategoryService categoryService;

    public List<Subcategory> findAll() {
        return subcategoryRepository.findAll();
    }

        public List<Subcategory> findByCategoryId(Long categoryId) {
        return subcategoryRepository.findByCategoryId(categoryId);
    }

    public Subcategory findById(Long id) {
        return subcategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Subcategoría no encontrada"));
    }

    public Subcategory create(Subcategory request) {
        Category category = categoryService.findById(request.getCategory().getId());
        request.setCategory(category);
        return subcategoryRepository.save(request);
    }

    public Subcategory update(Long id, Subcategory subcategoryDetails) {
        Subcategory subcategory = findById(id);
        subcategory.setName(subcategoryDetails.getName());
        subcategory.setDescription(subcategoryDetails.getDescription());
        subcategory.setActive(subcategoryDetails.getActive());
        subcategory.setCategory(subcategoryDetails.getCategory());
        return subcategoryRepository.save(subcategory);
    }

    public void delete(Long id) {
        Subcategory subcategory = findById(id);
        subcategoryRepository.delete(subcategory);
    }
}
