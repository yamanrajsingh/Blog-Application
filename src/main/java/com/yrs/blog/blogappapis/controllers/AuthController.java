package com.yrs.blog.blogappapis.controllers;

import com.yrs.blog.blogappapis.config.securityConfig.JwtHelper;
import com.yrs.blog.blogappapis.exceptions.ApiExceptionHandler;
import com.yrs.blog.blogappapis.payloads.JwtRequest;
import com.yrs.blog.blogappapis.payloads.JwtResponse;
import com.yrs.blog.blogappapis.payloads.UserDto;
import com.yrs.blog.blogappapis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody JwtRequest request) throws Exception {
        // Authenticate user
        String token;
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
            // Load user details
            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
            token = jwtHelper.generateToken(userDetails);
        } catch (BadCredentialsException e) {
            System.out.println("Invalid username or password");
            throw new ApiExceptionHandler("Invalid username or password");
        }


        return new JwtResponse(token);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) throws Exception {
    UserDto registerUser =  this.userService.registerUser(userDto);
    return new ResponseEntity<>(registerUser, HttpStatus.CREATED);
    }
}