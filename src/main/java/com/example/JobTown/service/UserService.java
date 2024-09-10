package com.example.JobTown.service;

import com.example.JobTown.model.entity.User;

public interface UserService {

    boolean existsByEmail(String email);

    void signup(User user);

    boolean signin(String email, String password);
}