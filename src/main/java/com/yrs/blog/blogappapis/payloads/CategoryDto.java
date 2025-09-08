package com.yrs.blog.blogappapis.payloads;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private int id;
    @NotBlank
    @Size(min = 3, max = 15, message = "Title must be minimum to 3 and maximum to 10 characters !!")
    private String title;
    @NotBlank
    @Size(min = 3, max = 25, message = "Description must be minimum to 3 and maximum to 15 characters !!")
    private String description;
}
