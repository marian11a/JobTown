package com.example.JobTown.model.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Job extends BaseEntity {

    private String title;
    private String description;
    private String location;
    private BigDecimal salary;
    private String employmentType;
    private LocalDateTime postedAt;
    private LocalDateTime expiresAt;

    // Many jobs belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Many jobs belong to one company
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    // Getters and setters

    // Add utility methods for convenience if needed
}
