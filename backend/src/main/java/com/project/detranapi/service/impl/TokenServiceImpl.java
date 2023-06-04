package com.project.detranapi.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.project.detranapi.model.User;
import com.project.detranapi.service.TokenService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenServiceImpl implements TokenService {

    @Transactional
    public String gerarToken (User user){
        return JWT.create()
                .withSubject(user.getLogin())
                .withClaim("id" , user.getId())
                .withExpiresAt(LocalDateTime.now().plusMinutes(10)
                        .toInstant(ZoneOffset.of("-03-00"))

                ).sign(Algorithm.HMAC256("secret"));
    }

}
