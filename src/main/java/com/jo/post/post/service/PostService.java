package com.jo.post.post.service;

import com.jo.post.post.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    void save(Post post);
    List<Post> findAll();
    Optional<Post> findById(Long id);
    void updatePost(Post post);
    void delPost(Long id);
}
