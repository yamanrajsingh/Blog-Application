package com.yrs.blog.blogappapis.services.impl;

import com.yrs.blog.blogappapis.entities.Post;
import com.yrs.blog.blogappapis.exceptions.ResourceNotFoundException;
import com.yrs.blog.blogappapis.payloads.PostDto;
import com.yrs.blog.blogappapis.repositories.PostRepo;
import com.yrs.blog.blogappapis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo  postRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
   public  PostDto createPost(PostDto postDto) {
        Post post  = DtoToPost(postDto);
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

   private Post DtoToPost(PostDto postDto) {
        Post post = this.modelMapper.map(postDto,Post.class);
        return post;
    }

    private  PostDto PostToDto(Post post){
        PostDto postDto = this.modelMapper.map(post, PostDto.class);
        return postDto;
    }
}
