package com.app.backend.controller;

import com.app.backend.models.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.backend.service.SubCategoryService;
import com.app.backend.dto.MessageResponse;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("api/subcategories")
@CrossOrigin(origins = "*")
public class SubcategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'COORDINADOR')")
    public ResponseEntity<List<Subcategory>> getAllSubcategories() {
        return ResponseEntity.ok(subCategoryService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'COORDINADOR')")
    public ResponseEntity<Subcategory> getsubcategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(subCategoryService.findById(id));
    }

    @GetMapping("/category/{categoryId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'COORDINADOR')")
    public ResponseEntity<List<Subcategory>> getSubcategoryByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(subCategoryService.findByCategoryId(categoryId));
    }
    
    
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'COORDINADOR')")
    public ResponseEntity<Subcategory> createsubcategory(@RequestBody Subcategory subcategory) {
        return ResponseEntity.ok(subCategoryService.create(subcategory));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'COORDINADOR')")
    public ResponseEntity<Subcategory> createsubcategory(@PathVariable Long id, @RequestBody Subcategory subcategory) {
        return ResponseEntity.ok(subCategoryService.update(id, subcategory));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> deletesubcategory(@PathVariable Long id) {
        subCategoryService.delete(id);
        return ResponseEntity.ok(new MessageResponse("subcategoria eliminada exitosamente"));
    }
}
