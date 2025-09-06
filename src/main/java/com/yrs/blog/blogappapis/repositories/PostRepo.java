package com.yrs.blog.blogappapis.repositories;

import com.yrs.blog.blogappapis.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post,Integer> {
}
