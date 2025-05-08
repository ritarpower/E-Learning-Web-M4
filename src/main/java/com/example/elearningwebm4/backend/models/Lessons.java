package com.example.elearningwebm4.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lessons")
public class Lessons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Long lessonId;

    @ManyToOne
    private Courses course;

    @Column(name = "topic_name", length = 255)
    private String topicName;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Lob
    @Column(name = "content", nullable = false, columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "video_url", nullable = false, length = 255)
    private String videoUrl;

    @Column(name = "order_index", nullable = false)
    private int orderIndex;
}
