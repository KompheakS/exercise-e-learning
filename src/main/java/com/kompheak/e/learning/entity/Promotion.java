package com.kompheak.e.learning.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promo_id")
    private Long promoId;

    @Column(name = "promo_name")
    private String promoName;

    @Column(name = "promo_type")
    private String promoType;

    @Column(name = "promo_amount")
    private BigDecimal promoAmount;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "applicable_courses", columnDefinition = "TEXT")
    private String applicableCourses;

    @Column(name = "discounted_courses", columnDefinition = "TEXT")
    private String discountedCourses;
}
