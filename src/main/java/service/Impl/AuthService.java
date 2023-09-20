package service.Impl;

import dto.JwtResponse;
import dto.LoginRequest;
import dto.LoginResponse;
import dto.RefreshTokenRequest;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    JwtResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}

