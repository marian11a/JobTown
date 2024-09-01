package com.example.JobTown.model.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Company extends BaseEntity {

    @Length(min = 3, max = 20)
    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    private String location;

    private String websiteUrl;

    // Many companies belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // One company can have many jobs
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Job> jobs = new HashSet<>();
}
