package com.yrs.blog.blogappapis.payloads;

import com.yrs.blog.blogappapis.entities.Post;
import com.yrs.blog.blogappapis.entities.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {

    private int id;

    @NotEmpty
    @Size(min = 10, max = 200, message = "comment should be minimum 10 and maximum 100 length")
    private String comment;

    private Date date;

    private User user;
    private Post post;


}
