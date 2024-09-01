package com.example.JobTown.repository;

import com.example.JobTown.model.entity.SavedJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SavedJobRepository extends JpaRepository<SavedJob, String> {
}