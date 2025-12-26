package com.example.demo.security;

import io.jsonwebtoken.Claims;

public class JwtPayloadWrapper {

    private final Claims claims;

    public JwtPayloadWrapper(Claims claims) {
        this.claims = claims;
    }

    public Claims getPayload() {
        return claims;
    }
}
