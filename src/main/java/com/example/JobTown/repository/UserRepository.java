package com.example.JobTown.repository;

import com.example.JobTown.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);

    boolean existsByEmail(String email);
}