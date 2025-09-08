package com.yrs.blog.blogappapis.services;
import com.yrs.blog.blogappapis.entities.User;
import com.yrs.blog.blogappapis.payloads.CategoryDto;
import com.yrs.blog.blogappapis.payloads.PostDto;
import com.yrs.blog.blogappapis.payloads.UserDto;

import java.util.List;

public interface PostService {
    // create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
    // update
    PostDto updatePost(PostDto postDto,Integer postId);
    // read by Id
    PostDto getPostById(Integer postId);
    // delete
    void deletePost(Integer postId);
    // get all post
    List<PostDto> getAllPosts();

    //  get all post by category
    List<PostDto> findByCategory(Integer categoryId);
    // get all post by user
    List<PostDto> findByUser(Integer userId);

//    // get post by search
    List<PostDto>searchPost(String search);
}
