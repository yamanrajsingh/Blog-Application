package com.yrs.blog.blogappapis.controllers;

import com.yrs.blog.blogappapis.payloads.CommentDto;
import com.yrs.blog.blogappapis.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    // Post Comment
    @PostMapping("/user/{userId}/post/{postId}")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer userId, @PathVariable Integer postId) {
        CommentDto comment = this.commentService.postComment(commentDto, postId, userId);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    // Delete Comment
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer id) {
        this.commentService.deleteCommentById(id);
        return new ResponseEntity<>(Map.of("message", "Comment Delete Succesfully"), HttpStatus.OK);
    }

    // Get all by Post
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentDto>> getAllCommentsByPostId(@PathVariable Integer postId) {
        List<CommentDto> commentDtoList = this.commentService.getAllCommentsByPostId(postId);
        return new ResponseEntity<>(commentDtoList, HttpStatus.OK);
    }

}
