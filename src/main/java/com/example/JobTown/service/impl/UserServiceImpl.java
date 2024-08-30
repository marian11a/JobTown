package com.example.JobTown.service.impl;

import com.example.JobTown.repository.UserRepository;
import com.example.JobTown.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
