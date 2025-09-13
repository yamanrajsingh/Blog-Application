package com.yrs.blog.blogappapis.services.impl;

import com.yrs.blog.blogappapis.entities.Comment;
import com.yrs.blog.blogappapis.entities.Post;
import com.yrs.blog.blogappapis.entities.User;
import com.yrs.blog.blogappapis.exceptions.ResourceNotFoundException;
import com.yrs.blog.blogappapis.payloads.CommentDto;
import com.yrs.blog.blogappapis.payloads.PostDto;
import com.yrs.blog.blogappapis.repositories.CommentRepo;
import com.yrs.blog.blogappapis.repositories.PostRepo;
import com.yrs.blog.blogappapis.repositories.UserRepo;
import com.yrs.blog.blogappapis.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CommentDto postComment(CommentDto commentDto, Integer postId, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setUser(user);
        comment.setPost(post);
        comment.setAddDate(new Date());
        Comment newComment = this.commentRepo.save(comment);
        return this.modelMapper.map(newComment, CommentDto.class);
    }

    @Override
    public void deleteCommentById(Integer commentId) {
        this.commentRepo.deleteById(commentId);

    }

    @Override
    public List<CommentDto> getAllCommentsByPostId(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        List<Comment> comments = this.commentRepo.findAllByPost(post);
        List<CommentDto> commentDtos  = comments.stream().map(comment -> this.modelMapper.map(comment,CommentDto.class)).collect(Collectors.toList());
        return commentDtos;
    }

}
