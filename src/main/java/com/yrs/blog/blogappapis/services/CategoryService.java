package com.yrs.blog.blogappapis.services;

import com.yrs.blog.blogappapis.payloads.CategoryDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    CategoryDto getCategory(Integer categoryId);
    List<CategoryDto> getAllCategories();
    void deleteCategory(Integer categoryId);
}
