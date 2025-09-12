package com.yrs.blog.blogappapis.services;

import com.yrs.blog.blogappapis.payloads.CommentDto;
import com.yrs.blog.blogappapis.repositories.CommentRepo;

import java.util.List;

public interface CommentService {

    CommentDto postComment(CommentDto commentDto, Integer postId, Integer userId);

    void deleteCommentById(Integer commentId);

    List<CommentRepo> getAllCommentsByPostId(Integer postId);

    List<CommentRepo> getAllCommentsByUserId(Integer userId);

    CommentDto updateComment(CommentDto commentDto, Integer commentId, Integer userId);


}
