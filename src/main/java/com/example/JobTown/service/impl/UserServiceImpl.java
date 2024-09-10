package com.example.JobTown.service.impl;

import com.example.JobTown.model.entity.User;
import com.example.JobTown.repository.UserRepository;
import com.example.JobTown.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    @Override
    public void signup(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
    }

    @Override
    public boolean signin(String email, String password) {
        if (!this.userRepository.existsByEmail(email)) {
            return false;
        }

        User user = userRepository.findByEmail(email);
        return passwordEncoder.matches(password, user.getPassword());
    }
}
