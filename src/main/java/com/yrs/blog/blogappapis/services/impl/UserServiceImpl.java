package com.yrs.blog.blogappapis.services.impl;

import com.yrs.blog.blogappapis.entities.User;
import com.yrs.blog.blogappapis.exceptions.ResourceNotFoundException;
import com.yrs.blog.blogappapis.payloads.UserDto;
import com.yrs.blog.blogappapis.repositories.UserRepo;
import com.yrs.blog.blogappapis.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser =  this.userRepo.save(user);
        return this.userToUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
       user.setPassword(userDto.getPassword());
       user.setAbout(userDto.getAbout());
       User updateUser = this.userRepo.save(user);
       return this.userToUserDto(updateUser);
    }
    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));

        return this.userToUserDto(user);
    }
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
      List<UserDto> userDtos =   users.stream().map(user-> this.userToUserDto(user)).collect(Collectors.toList());
        return userDtos;
    }
    @Override
    public   void deleteUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
        this.userRepo.delete(user);
    }

    private User dtoToUser(UserDto userDto) {

        User user = this.modelMapper.map(userDto,User.class);
//        User user = new User();
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setAbout(userDto.getAbout());
         return user;
    }

    public UserDto userToUserDto (User user) {
        UserDto userDto  =    this.modelMapper.map(user,UserDto.class);
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        userDto.setAbout(user.getAbout());
        return userDto;
    }



}
