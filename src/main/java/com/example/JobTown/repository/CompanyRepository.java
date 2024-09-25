package com.example.JobTown.repository;

import com.example.JobTown.model.entity.Company;
import com.example.JobTown.model.entity.OurUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    Optional<Company> findByName(String name);
}