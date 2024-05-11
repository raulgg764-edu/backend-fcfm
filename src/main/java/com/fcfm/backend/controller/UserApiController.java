package com.fcfm.backend.controller;

import com.fcfm.backend.model.User;
import com.fcfm.backend.responses.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public interface UserApiController {

    @PostMapping("/signup")
    public ResponseEntity<User> register(@Valid @RequestBody User userNuevo, BindingResult result);

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authUser(@Valid @RequestBody User userCredentials);


}
