package com.yrs.blog.blogappapis.repositories;

import com.yrs.blog.blogappapis.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
