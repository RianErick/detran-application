package com.project.detranapi.controller;

import com.project.detranapi.model.User;
import com.project.detranapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository ) {
        this.userRepository = userRepository;

    }

    @PostMapping("/cadastro")
    public User criarUser(@RequestBody User user) {
     user.setSenha(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


}
