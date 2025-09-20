package com.yrs.blog.blogappapis.controllers;

import com.yrs.blog.blogappapis.config.securityConfig.JwtHelper;
import com.yrs.blog.blogappapis.payloads.JwtRequest;
import com.yrs.blog.blogappapis.payloads.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
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

    @PostMapping("/login")
    public JwtResponse login(@RequestBody JwtRequest request) {
        // Authenticate user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // Load user details
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        // Generate token
        String token = jwtHelper.generateToken(userDetails);

        return new JwtResponse(token);
    }
}