package com.yrs.blog.blogappapis.controllers;


import com.yrs.blog.blogappapis.payloads.CategoryDto;
import com.yrs.blog.blogappapis.repositories.CategoryRepo;
import com.yrs.blog.blogappapis.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // Post
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto newCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer id) {
        CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, id);
        return new ResponseEntity<>(updateCategory, HttpStatus.OK);
    }

    // Delete
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        this.categoryService.deleteCategory(id);
        return new ResponseEntity(Map.of("message", "Category Delete Succesfully "), HttpStatus.OK);
    }


    // Get By Id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer id) {
        CategoryDto category = this.categoryService.getCategory(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    // Get All
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categoryDtos = this.categoryService.getAllCategories();
        return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
    }

}
