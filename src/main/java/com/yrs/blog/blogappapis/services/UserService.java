package com.yrs.blog.blogappapis.services;

import com.yrs.blog.blogappapis.payloads.UserDto;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDto registerUser(UserDto userDto);

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);

    void deleteUserById(Integer userId);

    List<UserDto> getAllUsers();

}
