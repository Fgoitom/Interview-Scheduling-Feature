package com.snva.security.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserResponseDto {
    private String refreshToken;
    private String jwtToken;




    public UserResponseDto(String refreshToken, String jwtToken) {
        this.refreshToken = refreshToken;
        this.jwtToken = jwtToken;

    }
}
