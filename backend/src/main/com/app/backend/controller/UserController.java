package com.main.app.backend.controller;

import com.app.backend.dto.loginRequest;
import com.app.backend.dto.loginResponse;
import com.app.backend.model.User;
import com.app.backend.repository.UserRepository;
import com.app.backend.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")

public class UserController{

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'COORDINADOR')")
    public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    



}


