package com.fcfm.backend.controller;

import com.fcfm.backend.model.User;
import com.fcfm.backend.responses.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;




@RequestMapping("/auth")
public interface UserApiController {

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody User userNuevo);

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authUser(@RequestBody User userCredentials);


}
