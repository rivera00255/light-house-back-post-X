package com.jo.post.post.service;

import com.jo.post.post.model.Post;
import com.jo.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(findById(id).get());
    }

    @Override
    public void updatePost(Post post) {
        Post updatePost = postRepository.findById(post.getId()).get();

        if(updatePost != null) {
            updatePost.setTitle(post.getTitle());
            updatePost.setContent(post.getContent());
        }
    }

    @Override
    public void delPost(Long id) {
        if(postRepository.findById(id).isPresent()) {
            postRepository.deleteById(id);
        }
    }
}
