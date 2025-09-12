package com.yrs.blog.blogappapis.repositories;

import com.yrs.blog.blogappapis.entities.Comment;
import com.yrs.blog.blogappapis.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo  extends JpaRepository<Comment,Integer> {
    List<Comment> findAllByPost(Post post);

}
