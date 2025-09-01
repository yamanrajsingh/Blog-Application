package com.yrs.blog.blogappapis.services;

import com.yrs.blog.blogappapis.payloads.UserDto;

import java.util.List;

public interface UserService {
   UserDto createUser( UserDto user);
   UserDto updateUser( UserDto user,Integer userId);
   UserDto getUserById( Integer userId);
   void deleteUserById( Integer userId);
   List<UserDto> getAllUsers();

}
