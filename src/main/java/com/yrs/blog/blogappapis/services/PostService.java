package com.yrs.blog.blogappapis.services;
import com.yrs.blog.blogappapis.payloads.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto updatePost(PostDto postDto,Integer postId);
    PostDto getPostById(Integer postId);
    void deletePost(Integer postId);
    List<PostDto> getAllPosts();
}
