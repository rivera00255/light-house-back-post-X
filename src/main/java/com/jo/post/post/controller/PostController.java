package com.jo.post.post.controller;

import com.jo.post.post.model.Post;
import com.jo.post.post.model.PostDto;
import com.jo.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public void savePost(@RequestBody PostDto postDto) {
        postService.savePost(postDto);
    }

    @PutMapping("/post/{id}")
    public void editPost(@PathVariable Long id, @RequestBody PostDto postDto) {
        postService.editPost(id, postDto);
    }

    @GetMapping("/post")
    public List<Post> findAllPost() {
        return postService.findAllPost();
    }

    @GetMapping("/post/{id}")
    public Post findById(@PathVariable Long id) {
        return postService.findById(id).get();
    }

    @DeleteMapping("/post/{id}")
    public void delPost(@PathVariable Long id) {
        postService.delPost(id);
    }

}
