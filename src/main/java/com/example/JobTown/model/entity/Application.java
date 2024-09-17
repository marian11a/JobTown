package com.example.JobTown.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Application extends BaseEntity {

    private String resumeUrl;
    private String coverLetter;
    private LocalDateTime appliedAt;
    private String status;

    // Many applications belong to one user
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

    // Many applications belong to one job
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    // Getters and setters

    // Add utility methods for convenience if needed
}
