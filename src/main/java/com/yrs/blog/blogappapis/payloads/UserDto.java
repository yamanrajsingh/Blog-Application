package com.yrs.blog.blogappapis.payloads;


import com.yrs.blog.blogappapis.entities.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 3, max = 15, message = "Username must be minimum to 3 and maximum to 15 characters !!")
    private String name;

    @NotEmpty
    @Size(min = 5, max = 15, message = "Password must be minimum to 5 and maximum to 15 characters!!")
    private String password;

    @Email(message = "Email Address is not Valid !!")
    private String email;

    @NotEmpty
    private String about;

    private Set<RoleDto> roles = new HashSet<>();
}
