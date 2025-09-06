package com.yrs.blog.blogappapis.controllers;


import com.yrs.blog.blogappapis.payloads.PostDto;
import com.yrs.blog.blogappapis.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    // Post - Add Post

    @PostMapping("/")
    public ResponseEntity<PostDto> createPost( @Valid @RequestBody PostDto postDto){
         PostDto newPost = this.postService.createPost(postDto);
         return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    // Put - Update Post
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost( @Valid @RequestBody PostDto postDto, @PathVariable Integer id){
        PostDto updatePost = this.postService.updatePost(postDto,id);
        return new ResponseEntity<>(updatePost, HttpStatus.OK);
    }

    // Get - getbyId
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer id){
        PostDto postDto = this.postService.getPostById(id);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        List<PostDto> postDtoList = this.postService.getAllPosts();
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }
    // Delete Post
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer id){
        this.postService.deletePost(id);
        return new ResponseEntity<>(Map.of("message","Post Delete Succesfully") ,HttpStatus.OK);
    }

}
