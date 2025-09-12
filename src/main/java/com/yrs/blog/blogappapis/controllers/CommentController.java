//package com.yrs.blog.blogappapis.controllers;
//
//import com.yrs.blog.blogappapis.payloads.CommentDto;
//import com.yrs.blog.blogappapis.services.CommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/posts/comment")
//public class CommentController {
//    @Autowired
//    private CommentService commentService;
//
//    @PostMapping("/user/{userId}/post/{postId}")
//    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer userId, @PathVariable Integer postId) {
//        CommentDto comment = this.commentService.postComment(commentDto, postId, userId);
//        return new ResponseEntity<>(comment, HttpStatus.CREATED);
//    }
//
//}
