package com.yrs.blog.blogappapis.repositories;

import com.yrs.blog.blogappapis.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo  extends JpaRepository<Comment,Integer> {

}
