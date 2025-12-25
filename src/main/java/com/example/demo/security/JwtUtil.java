package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.*;

public class JwtUtil {

    private Key key;

    public void initKey() {
        key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .signWith(key)
                .compact();
    }

    public String generateTokenForUser(UserAccount u) {
        Map<String, Object> c = new HashMap<>();
        c.put("email", u.getEmail());
        c.put("role", u.getRole());
        c.put("userId", u.getId());
        return generateToken(c, u.getEmail());
    }

    /** 🔥 MUST return Jws<Claims> */
    public Jws<Claims> parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }

    public String extractUsername(String token) {
        return parseToken(token).getBody().getSubject();
    }

    public String extractRole(String token) {
        return (String) parseToken(token).getBody().get("role");
    }

    public Long extractUserId(String token) {
        return Long.valueOf(parseToken(token).getBody().get("userId").toString());
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username);
    }
}
