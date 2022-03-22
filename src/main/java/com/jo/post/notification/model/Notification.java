package com.jo.post.notification.model;

import com.jo.post.util.BaseTime;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Notification extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String content;

    @Builder
    public Notification(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
