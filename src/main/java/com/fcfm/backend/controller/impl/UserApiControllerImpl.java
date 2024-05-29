package com.fcfm.backend.controller.impl;

import com.fcfm.backend.controller.UserApiController;
import com.fcfm.backend.model.User;
import com.fcfm.backend.responses.LoginResponse;
import com.fcfm.backend.service.AuthenticationService;
import com.fcfm.backend.service.JwtService;
import com.fcfm.backend.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiControllerImpl implements UserApiController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @Autowired
    public UserApiControllerImpl(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @Override
    public ResponseEntity<User> register(User userNuevo) {
        User registeredUser = UserMapper.userEntityToUserModel(authenticationService.signup(userNuevo));

        return ResponseEntity.ok(registeredUser);


    }

    @Override
    public ResponseEntity<LoginResponse> authUser(User userCredentials) {
        com.fcfm.backend.repository.entity.User authenticatedUser = authenticationService.authenticate(userCredentials);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
