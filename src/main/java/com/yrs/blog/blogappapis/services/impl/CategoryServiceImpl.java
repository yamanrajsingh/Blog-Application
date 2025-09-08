package com.yrs.blog.blogappapis.services.impl;

import com.yrs.blog.blogappapis.entities.Category;
import com.yrs.blog.blogappapis.exceptions.ResourceNotFoundException;
import com.yrs.blog.blogappapis.payloads.CategoryDto;
import com.yrs.blog.blogappapis.repositories.CategoryRepo;
import com.yrs.blog.blogappapis.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = DtoToCategory(categoryDto);
        Category newCategory = this.categoryRepo.save(category);
        return CategoryToDto(newCategory);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
        Category category = this.categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());
        Category updateCategory = this.categoryRepo.save(category);
        return CategoryToDto(updateCategory);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category category = this.categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        this.categoryRepo.delete(category);
    }

    @Override
    public CategoryDto getCategory(Integer id) {
        Category category = this.categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        return CategoryToDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map(category -> {
            return CategoryToDto(category);
        }).collect(Collectors.toList());
        return categoryDtos;
    }


    public CategoryDto CategoryToDto(Category category) {
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }

    public Category DtoToCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        return category;
    }

}
