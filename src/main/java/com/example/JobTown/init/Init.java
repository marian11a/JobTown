package com.example.JobTown.init;

import com.example.JobTown.model.entity.Company;
import com.example.JobTown.model.entity.Job;
import com.example.JobTown.model.entity.OurUser;
import com.example.JobTown.model.enums.RoleEnum;
import com.example.JobTown.repository.CompanyRepository;
import com.example.JobTown.repository.JobRepository;
import com.example.JobTown.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class Init implements CommandLineRunner {

    private final JobRepository jobRepository;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    private final PasswordEncoder passwordEncoder;

    public Init(JobRepository jobRepository,
                UserRepository userRepository,
                CompanyRepository companyRepository,
                PasswordEncoder passwordEncoder) {
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.userRepository.count() <= 0) {
            OurUser user = createUser();
            this.userRepository.save(user);

            if (this.companyRepository.count() <= 0) {
                Company company1 = createCompany("Tech Solutions", "A leading tech company", "San Francisco, CA", "https://techsolutions.com");
                Company company2 = createCompany("Data Innovators", "Data analytics and solutions", "New York, NY", "https://datainnovators.com");
                this.companyRepository.saveAll(List.of(company1, company2));
            }

            if (this.jobRepository.count() <= 0) {
                List<Job> jobs = List.of(
                        createJob("Software Engineer", "Develop and maintain web applications.", "New York, NY", new BigDecimal("100000"), "Full-time", "Data Innovators"),
                        createJob("Data Scientist", "Analyze large datasets to extract insights.", "San Francisco, CA", new BigDecimal("120000"), "Part-time", "Tech Solutions"),
                        createJob("Project Manager", "Manage software development projects.", "Austin, TX", new BigDecimal("90000"), "Full-time", "Data Innovators"),
                        createJob("DevOps Engineer", "Maintain and improve CI/CD pipelines.", "Seattle, WA", new BigDecimal("110000"), "Full-time", "Tech Solutions"),
                        createJob("Product Manager", "Lead product development teams.", "Boston, MA", new BigDecimal("105000"), "Full-time", "Tech Solutions")
                );
                jobRepository.saveAll(jobs);
            }
        }
    }

    private OurUser createUser() {
        OurUser user = new OurUser();
        user.setEmail("admin@abv.bg");
        user.setName("Admin Adminov");
        user.setCity("Sofia");
        user.setRole(RoleEnum.ADMIN.name());
        user.setPassword(this.passwordEncoder.encode("admin123"));
        return user;
    }

    private Company createCompany(String name,
                                  String description,
                                  String location,
                                  String websiteUrl) {
        Company company = new Company();
        company.setName(name);
        company.setDescription(description);
        company.setLocation(location);
        company.setWebsiteUrl(websiteUrl);

        Optional<OurUser> byEmail = this.userRepository.findByEmail("admin@abv.bg");
        byEmail.ifPresent(company::setUser);
        return company;
    }

    private Job createJob(String title,
                          String description,
                          String location,
                          BigDecimal salary,
                          String employmentType,
                          String companyName) {
        Job job = new Job();
        job.setTitle(title);
        job.setDescription(description);
        job.setLocation(location);
        job.setSalary(salary);
        job.setEmploymentType(employmentType);
        job.setPostedAt(LocalDateTime.now());
        job.setExpiresAt(LocalDateTime.now().plusMonths(1));

        Optional<OurUser> userByEmail = this.userRepository.findByEmail("admin@abv.bg");
        userByEmail.ifPresent(job::setUser);

        Optional<Company> companyByName = this.companyRepository.findByName(companyName);
        companyByName.ifPresent(job::setCompany);

        return job;
    }
}
