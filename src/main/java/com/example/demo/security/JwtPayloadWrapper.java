package com.example.demo.security;

import io.jsonwebtoken.Claims;

/**
 * Adapter to satisfy test expectation:
 * parseToken(token).getPayload()
 */
public class JwtPayloadWrapper {

    private final Claims claims;

    public JwtPayloadWrapper(Claims claims) {
        this.claims = claims;
    }

    public Claims getPayload() {
        return claims;
    }
}
