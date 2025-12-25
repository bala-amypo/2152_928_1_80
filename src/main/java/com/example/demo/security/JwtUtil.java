package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.*;

public class JwtUtil {

    private Key key;

    public void initKey() {
        key = new SecretKeySpec(
                Base64.getEncoder().encode("secretkey123456".getBytes()),
                SignatureAlgorithm.HS256.getJcaName()
        );
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .signWith(key)
                .compact();
    }

    public String generateTokenForUser(UserAccount ua) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", ua.getEmail());
        claims.put("role", ua.getRole());
        claims.put("userId", ua.getId());
        return generateToken(claims, ua.getEmail());
    }

    public boolean isTokenValid(String token, String email) {
        return extractUsername(token).equals(email);
    }

    public String extractUsername(String token) {
        return parseToken(token).getBody().getSubject();
    }

    public String extractRole(String token) {
        return (String) parseToken(token).getBody().get("role");
    }

    public Long extractUserId(String token) {
        Object id = parseToken(token).getBody().get("userId");
        return id == null ? null : Long.valueOf(id.toString());
    }

    public Jws<Claims> parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }
}
