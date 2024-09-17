package com.example.JobTown.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SavedJob extends BaseEntity {

    // Many saved jobs belong to one user
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

    // One saved job is associated with one job
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    private LocalDateTime savedAt;

    // Getters and setters

    // Add utility methods for convenience if needed
}
