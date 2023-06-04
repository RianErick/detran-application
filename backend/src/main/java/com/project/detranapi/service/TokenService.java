package com.project.detranapi.service;

import com.project.detranapi.model.User;

public interface TokenService {

    String gerarToken(User user);
}
