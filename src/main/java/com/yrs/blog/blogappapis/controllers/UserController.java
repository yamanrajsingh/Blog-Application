package com.yrs.blog.blogappapis.controllers;

import com.yrs.blog.blogappapis.payloads.UserDto;
import com.yrs.blog.blogappapis.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserService userService;

    // Post -  create User

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser( @Valid @RequestBody UserDto userDto){
    UserDto newUser =   this.userService.createUser(userDto);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // Put - Update User
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser( @Valid @RequestBody UserDto userDto,@PathVariable Integer userId){
    UserDto updateUser = this.userService.updateUser(userDto,userId);
    return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    // Delete - Delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
    this.userService.deleteUserById(userId);
    return new ResponseEntity(Map.of("message","User Delete Succesfully "),HttpStatus.OK);
    }

    // Get - Get user
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
    UserDto userDto = this.userService.getUserById(userId);
    return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
    List<UserDto> userDtos = this.userService.getAllUsers();
    return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }
}
