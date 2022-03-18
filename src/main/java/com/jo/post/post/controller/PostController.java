package com.jo.post.post.controller;

import com.jo.post.post.model.Post;
import com.jo.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public void save(@RequestBody Post post) {
        postService.save(post);
    }

    @PutMapping("/post")
    public void updatePost(@RequestBody Post post) {
        postService.updatePost(post);
    }

    @GetMapping("/post")
    public List<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping("/post/{id}")
    public Optional<Post> findById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @DeleteMapping("/post")
    public void delPost(@PathVariable Long id) {
        postService.delPost(id);
    }

}
