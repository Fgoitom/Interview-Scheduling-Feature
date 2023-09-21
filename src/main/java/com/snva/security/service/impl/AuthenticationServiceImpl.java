package com.snva.security.service.impl;

import com.snva.security.dao.request.SignUpRequest;
import com.snva.security.dao.request.SigninRequest;
import com.snva.security.dao.response.JwtAuthenticationResponse;
import com.snva.security.model.Role;
import com.snva.security.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import com.snva.security.repository.UserRepo;
import com.snva.security.service.AuthenticationService;
import com.snva.security.service.JwtService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
