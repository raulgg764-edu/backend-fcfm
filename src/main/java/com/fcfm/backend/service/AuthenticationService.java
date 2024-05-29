package com.fcfm.backend.service;

import com.fcfm.backend.repository.entity.User;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

public interface AuthenticationService {

    public User signup(com.fcfm.backend.model.User input);

    public User authenticate(com.fcfm.backend.model.User input);
}