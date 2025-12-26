package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private static final long EXPIRATION = 1000 * 60 * 60; // 1 hour
    private Key key;

    // Called manually in tests
    public void initKey() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    /* =====================================================
       TEST-EXPECTED METHODS
       ===================================================== */

    // Used directly in tests
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key)
                .compact();
    }

    public JwtPayloadWrapper parseToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return new JwtPayloadWrapper(claims);
    }

    public String extractUsername(String token) {
        return parseToken(token).getPayload().getSubject();
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username);
    }

    /* =====================================================
       SPRING SECURITY / CONTROLLER METHODS
       ===================================================== */

    // Used by JwtAuthenticationFilter
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException ex) {
            return false;
        }
    }

    // Used by AuthController
    public String generateTokenForUser(UserAccount user) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());

        return generateToken(claims, user.getEmail());
    }

    public Long extractUserId(String token) {
        Object id = parseToken(token).getPayload().get("userId");
        return Long.valueOf(id.toString());
    }

    public String extractRole(String token) {
        return (String) parseToken(token).getPayload().get("role");
    }
}
