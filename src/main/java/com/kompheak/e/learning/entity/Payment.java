package com.kompheak.e.learning.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "amount_paid")
    private BigDecimal amountPaid;

    @Column(name = "payment_status")
    private String paymentStatus; // Paid / Pending
}
