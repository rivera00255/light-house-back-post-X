package com.jo.post.post.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PostImg {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    private String url;
}
