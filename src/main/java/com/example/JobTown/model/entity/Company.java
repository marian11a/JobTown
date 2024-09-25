package com.example.JobTown.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "companies")
@Data
public class Company extends BaseEntity {

    @Length(min = 3, max = 20)
    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    private String location;

    private String websiteUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private OurUser user;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Job> jobs = new HashSet<>();
}
