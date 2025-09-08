package com.yrs.blog.blogappapis.services.impl;

import com.yrs.blog.blogappapis.entities.Category;
import com.yrs.blog.blogappapis.entities.Post;
import com.yrs.blog.blogappapis.entities.User;

import com.yrs.blog.blogappapis.exceptions.ResourceNotFoundException;

import com.yrs.blog.blogappapis.payloads.PostDto;

import com.yrs.blog.blogappapis.repositories.CategoryRepo;
import com.yrs.blog.blogappapis.repositories.PostRepo;
import com.yrs.blog.blogappapis.repositories.UserRepo;

import com.yrs.blog.blogappapis.services.PostService;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo  postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
   public  PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","id",categoryId));
        Post post  = DtoToPost(postDto);
        post.setImgUrl("default.jpg");
        post.setAddDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post newPost =  this.postRepo.save(post);
        return PostToDto(newPost);
    }
    @Override
   public PostDto updatePost(PostDto postDto, Integer postId)
    {
        Post post  = DtoToPost(postDto);
        post = this.postRepo.findById(postId).orElseThrow( () -> new ResourceNotFoundException("Post","id",postId));
        post.setTitle((postDto.getTitle()));
        post.setContent((postDto.getContent()));
        post.setImgUrl((postDto.getImgUrl()));
        Post updatePost = this.postRepo.save(post);
        return this.PostToDto(updatePost);
    }

    @Override
    public PostDto getPostById(Integer postId) {
       Post post  = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","id",postId));
       return PostToDto(post);
    }

    @Override
    public void deletePost(Integer postId){
        this.postRepo.deleteById(postId);
    }

   @Override
    public List<PostDto> getAllPosts(){
        List<Post> posts = this.postRepo.findAll();
        List<PostDto> postDtos = posts.stream().map(post -> this.PostToDto(post)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> findByCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","id",categoryId));
        List<Post> posts = this.postRepo.findByCategory(category);
        List<PostDto> postDto = posts.stream().map(post->this.PostToDto(post)).collect(Collectors.toList());
        return postDto;
    }

    @Override
    public List<PostDto> findByUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        List<Post> posts = this.postRepo.findByUser(user);
        List<PostDto> postDto = posts.stream().map(post->this.PostToDto(post)).collect(Collectors.toList());
        return postDto;
    }
    @Override
    public List<PostDto> searchPost(String search){
        return null;
    }



    private Post DtoToPost(PostDto postDto) {
        Post post = this.modelMapper.map(postDto,Post.class);
        return post;
    }

    private  PostDto PostToDto(Post post){
        PostDto postDto = this.modelMapper.map(post, PostDto.class);
        return postDto;
    }
}
