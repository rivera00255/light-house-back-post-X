package com.jo.post.post.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

    private String category;
    private String title;
    private String content;

    public PostDto(String category, String title, String content) {
        this.category = category;
        this.title = title;
        this.content = content;
    }
}
