package com.example.JobTown.service.impl;

import com.example.JobTown.model.entity.User;
import com.example.JobTown.repository.UserRepository;
import com.example.JobTown.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<String> getAllUsers() {
        List<User> allUsers = this.userRepository.findAll();
        List<String> names = new ArrayList<>();
        for (User user : allUsers) {
            names.add(user.getUsername());
        }

        return names;
    }
}
