package com.snva.security.service;

import com.snva.security.dao.request.SignUpRequest;
import com.snva.security.dao.request.SigninRequest;
import com.snva.security.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
