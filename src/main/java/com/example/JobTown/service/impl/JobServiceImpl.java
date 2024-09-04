package com.example.JobTown.service.impl;

import com.example.JobTown.model.entity.Job;
import com.example.JobTown.repository.JobRepository;
import com.example.JobTown.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllJobs() {
        return this.jobRepository.findAll();
    }
}
