package com.example.JobTown.web.restControllers;

import com.example.JobTown.model.entity.User;
import com.example.JobTown.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService,
                          PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        if (userService.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already in use.");
        }

        userService.signup(user);
        return ResponseEntity.ok("User registered successfully");
    }

//    @PostMapping("/signin")
//    public ResponseEntity<String> signin(@RequestBody User user) {
//        String email = user.getEmail();
//        String password = user.getPassword();
//
//        if (!userService.signin(email, password)) {
//            return ResponseEntity.badRequest().body("Invalid email or password.");
//        }
//
//        return ResponseEntity.ok("User signed in successfully");
//    }

    @GetMapping("/auth-status")
    public ResponseEntity<String> checkAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null
                && authentication.isAuthenticated()
                && !(authentication instanceof AnonymousAuthenticationToken)) {
            System.out.println("******************************************************************************************************************88");
            return ResponseEntity.ok("Authenticated");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not Authenticated");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // Invalidate the session or perform logout operations
        // This is often handled automatically by Spring Security
        return ResponseEntity.ok("Logged out successfully");
    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
