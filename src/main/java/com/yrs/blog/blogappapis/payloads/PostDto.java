package com.yrs.blog.blogappapis.payloads;

import com.yrs.blog.blogappapis.entities.Comment;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private int id;
    @NotEmpty
    @Size(min = 4, max = 100, message = " Title length should be minimum 4 and maximum 100")
    private String title;
    @NotEmpty
    @Size(min = 4, max = 200, message = "Content length should be minimum 4 and maximum 200")
    private String content;

    private String imgUrl;
    private Date addDate;

    private CategoryDto category;

    private List<CommentDto> comments;

    private UserDto user;

}
