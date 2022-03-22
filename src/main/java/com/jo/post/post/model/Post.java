package com.jo.post.post.model;

import com.jo.post.util.BaseTime;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Post extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;


    @Builder
    public Post(String category, String title, String content) {
        this.category = category;
        this.title = title;
        this.content = content;
    }
}
