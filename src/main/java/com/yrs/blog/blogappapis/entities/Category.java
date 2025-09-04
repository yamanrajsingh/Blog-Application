package com.yrs.blog.blogappapis.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoty_id")
    private int id;

    @Column(name ="title",length=10,nullable = false)
    private  String title;

    @Column(name ="description",length=100,nullable = false)
    private String description;

}
