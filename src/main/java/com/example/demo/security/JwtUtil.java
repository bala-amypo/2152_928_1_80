package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private static final long EXPIRATION = 1000 * 60 * 60;
    private Key key;

    public void initKey() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    // 🔹 REQUIRED BY TEST
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key)
                .compact();
    }

    // 🔹 REQUIRED BY TEST
    public JwtPayloadWrapper parseToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return new JwtPayloadWrapper(claims);
    }

    // 🔹 REQUIRED BY TEST
    public String extractUsername(String token) {
        return parseToken(token).getPayload().getSubject();
    }

    // 🔹 REQUIRED BY TEST
    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username);
    }
}
