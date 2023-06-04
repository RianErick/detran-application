package com.project.detranapi.controller;

import com.project.detranapi.model.User;
import com.project.detranapi.repository.UserRepository;
import com.project.detranapi.representation.LoginDTO;
import com.project.detranapi.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {

        UsernamePasswordAuthenticationToken usernameAuthentication = new
                UsernamePasswordAuthenticationToken(loginDTO.login(), loginDTO.senha());

        Authentication authenticate = this.authenticationManager.authenticate(usernameAuthentication);

        var user = (User) authenticate.getPrincipal();

        return tokenService.gerarToken(user);

    }

    @PostMapping("/cadastro")
    public User criarUser(@RequestBody User user) {
        return userRepository.save(user);
    }


}
