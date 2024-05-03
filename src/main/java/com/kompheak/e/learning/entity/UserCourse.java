package com.kompheak.e.learning.entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "user_course")
public class UserCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
