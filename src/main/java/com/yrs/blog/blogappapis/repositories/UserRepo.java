package com.yrs.blog.blogappapis.repositories;

import com.yrs.blog.blogappapis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {


}
