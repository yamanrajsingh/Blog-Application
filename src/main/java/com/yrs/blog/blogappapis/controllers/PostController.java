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
@RequestMapping("/api/posts/")
public class PostController {
    @Autowired
    private PostService postService;

    // Post - Add Post --> Working
    @PostMapping("/user/{userId}/category/{categoryId}/")
    public ResponseEntity<PostDto> createPost( @Valid @RequestBody PostDto postDto,@PathVariable Integer userId, @PathVariable Integer categoryId) {
         PostDto newPost = this.postService.createPost(postDto,userId,categoryId);
         return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    // Get - getbyId --> Working
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer id){
        PostDto postDto = this.postService.getPostById(id);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    // Get - all post --> Working
    @GetMapping("/")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        List<PostDto> postDtoList = this.postService.getAllPosts();
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }

    // Put - Update Post ->working
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost( @Valid @RequestBody PostDto postDto, @PathVariable Integer id){
        PostDto updatePost = this.postService.updatePost(postDto,id);
        return new ResponseEntity<>(updatePost, HttpStatus.OK);
    }

    // Delete Post  -> working
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer id){
        this.postService.deletePost(id);
        return new ResponseEntity<>(Map.of("message","Post Delete Succesfully") ,HttpStatus.OK);
    }

    // Get By Category --> Working
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<PostDto>> findByCategory(@PathVariable Integer categoryId){
        List<PostDto> postDtoList = this.postService.findByCategory(categoryId);
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }

    // Get By User --> Working
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostDto>> findByUser(@PathVariable Integer userId){
        List<PostDto> postDto = this.postService.findByUser(userId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

}
