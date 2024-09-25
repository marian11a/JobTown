package com.example.JobTown.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
@Data
public class Job extends BaseEntity {

    private String title;
    private String description;
    private String location;
    private BigDecimal salary;
    private String employmentType;
    private LocalDateTime postedAt;
    private LocalDateTime expiresAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = true)
    private OurUser user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", nullable = true)
    private Company company;
}
