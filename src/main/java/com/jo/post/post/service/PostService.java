package com.jo.post.post.service;

import com.jo.post.post.model.Post;
import com.jo.post.post.model.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostService {

    void savePost(PostDto postDto);
    List<Post> findAllPost();
    Optional<Post> findById(Long id);
    void editPost(Long id, PostDto postDto);
    void delPost(Long id);
}
