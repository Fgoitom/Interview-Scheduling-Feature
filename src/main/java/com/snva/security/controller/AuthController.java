package com.snva.security.controller;

import com.snva.security.dao.request.SignUpRequest;
import com.snva.security.dao.request.SigninRequest;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.snva.security.service.AuthenticationService;


@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;
//    public AuthController(AuthService authService){
//        this.authService = authService;
//    }
    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody SigninRequest loginRequest) {
        var loginResponse = authenticationService.signin(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }
    @PostMapping("/signup")
    public ResponseEntity<?> refreshToken(@RequestBody SignUpRequest refreshTokenRequest){
        var loginResponse= authenticationService.signup(refreshTokenRequest);
        return ResponseEntity.ok().body(loginResponse);
    }
}
