package com.example.JobTown.init;

import com.example.JobTown.model.entity.User;
import com.example.JobTown.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserInit implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserInit(UserRepository userRepository,
                    PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.userRepository.count() <= 0) {
                User user = new User();
                user.setEmail("admin@abv.bg");
                user.setPassword(passwordEncoder.encode("admin"));
                this.userRepository.save(user);
        }
    }
}