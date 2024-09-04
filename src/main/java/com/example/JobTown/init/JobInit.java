package com.example.JobTown.init;

import com.example.JobTown.model.entity.Job;
import com.example.JobTown.repository.JobRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class JobInit implements CommandLineRunner {

    private final JobRepository jobRepository;

    public JobInit(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.jobRepository.count() <= 0) {
            List<Job> jobs = List.of(
                    createJob("Software Engineer", "Develop and maintain web applications.", "New York, NY", new BigDecimal("100000"), "Full-time"),
                    createJob("Data Scientist", "Analyze large datasets to extract insights.", "San Francisco, CA", new BigDecimal("120000"), "Full-time"),
                    createJob("Project Manager", "Manage software development projects.", "Austin, TX", new BigDecimal("90000"), "Full-time"),
                    createJob("DevOps Engineer", "Maintain and improve CI/CD pipelines.", "Seattle, WA", new BigDecimal("110000"), "Full-time"),
                    createJob("Product Manager", "Lead product development teams.", "Boston, MA", new BigDecimal("105000"), "Full-time")
            );

            jobRepository.saveAll(jobs);
        }
    }

    private Job createJob(String title, String description, String location, BigDecimal salary, String employmentType) {
        Job job = new Job();
        job.setTitle(title);
        job.setDescription(description);
        job.setLocation(location);
        job.setSalary(salary);
        job.setEmploymentType(employmentType);
        job.setPostedAt(LocalDateTime.now());
        job.setExpiresAt(LocalDateTime.now().plusMonths(1));
        return job;
    }
}
