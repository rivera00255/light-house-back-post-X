package com.jo.post.post.service;

import com.jo.post.post.model.Category;
import com.jo.post.post.model.Post;
import com.jo.post.post.model.PostDto;
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
    public void savePost(PostDto postDto) {
        try {
            if(postDto.getCategory().equals("인증")) {
                postRepository.save(Post.builder()
                        .category(Category.DAILY)
                        .title(postDto.getTitle())
                        .content(postDto.getContent())
                        .build());
            } else if(postDto.getCategory().equals("자랑")) {
                postRepository.save(Post.builder()
                        .category(Category.PHOTO)
                        .title(postDto.getTitle())
                        .content(postDto.getContent())
                        .build());
            } else {
                log.error("save post category error : {}", postDto.getCategory());
            }

        } catch (Exception e) {
            log.error("save post error : {}", e.getMessage());
        }
    }

    @Override
    public List<Post> findAllPost() {
        try {
            return postRepository.findAll();
        } catch (Exception e) {
            log.error("find all post error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public Optional<Post> findById(Long id) {
        try {
            log.info("find by post id : {}", id);
            return Optional.ofNullable(postRepository.findById(id).get());
        } catch(Exception e) {
            log.error("find by post id error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public void editPost(Long id, PostDto postDto) {
       try {
           Post post = postRepository.findById(id).get();

           if(post != null) {
               if(postDto.getCategory().equals("인증")) {
                   post.setTitle(postDto.getTitle());
                   post.setContent(postDto.getContent());
                   post.setCategory(Category.DAILY);
               } else if(postDto.getCategory().equals("자랑")) {
                   post.setTitle(postDto.getTitle());
                   post.setContent(postDto.getContent());
                   post.setCategory(Category.PHOTO);
               } else {
                   log.error("edit post category error : {}", postDto.getCategory());
               }
           }

           postRepository.save(post);
       } catch(Exception e) {
           log.error("edit post error : {}", e.getMessage());
       }
    }

    @Override
    public void delPost(Long id) {
        try {
            if(postRepository.findById(id).isPresent()) {
                postRepository.deleteById(id);
            }
        } catch (Exception e) {
            log.error("delete post error : {}", e.getMessage());
        }
    }
}
