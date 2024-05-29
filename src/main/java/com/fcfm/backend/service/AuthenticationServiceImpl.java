package com.fcfm.backend.service;


import com.fcfm.backend.model.User;
import com.fcfm.backend.repository.UserRepository;
import com.fcfm.backend.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public com.fcfm.backend.repository.entity.User signup(User input) {
        com.fcfm.backend.repository.entity.User newUser = new com.fcfm.backend.repository.entity.User();
        newUser.setUsername(input.getUsername());
        newUser.setPass(passwordEncoder.encode(input.getPass()));

        return userRepository.save(newUser);
    }

    public com.fcfm.backend.repository.entity.User authenticate(com.fcfm.backend.model.User input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPass()
                )
        );

        return userRepository.findByUsername(input.getUsername())
                .orElseThrow();
    }
}