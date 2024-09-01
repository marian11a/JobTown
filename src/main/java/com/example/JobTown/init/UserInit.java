package com.example.JobTown.init;

import com.example.JobTown.model.entity.User;
import com.example.JobTown.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserInit implements CommandLineRunner {
    private final UserRepository userRepository;

    public UserInit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.userRepository.count() <= 0) {
            for (int i = 0; i < 10; i++) {
                User user = new User();
                user.setEmail("test@abv.bg" + i);
                user.setPassword("1234");
                user.setUsername("test" + i);
                this.userRepository.save(user);
            }
        }
    }
}