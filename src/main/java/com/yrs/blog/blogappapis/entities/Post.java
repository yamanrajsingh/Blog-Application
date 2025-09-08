package com.yrs.blog.blogappapis.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private int id;

    @Column(name = "post_title", nullable = false,  length = 100)
    private String title;

    @Column(name = "post_content", nullable = false,  length = 200)
    private String content;

    @Column(name = "post_imgUrl", nullable = false)
    private String imgUrl;

    @Column(name ="post_date")
    private Date addDate;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
