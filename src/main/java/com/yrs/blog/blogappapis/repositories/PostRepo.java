package com.yrs.blog.blogappapis.repositories;

import com.yrs.blog.blogappapis.entities.Category;
import com.yrs.blog.blogappapis.entities.Post;
import com.yrs.blog.blogappapis.entities.User;
import com.yrs.blog.blogappapis.payloads.CategoryDto;
import com.yrs.blog.blogappapis.payloads.PostDto;
import com.yrs.blog.blogappapis.payloads.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findByCategory(Category category);
    List<Post> findByUser(User user);
}
