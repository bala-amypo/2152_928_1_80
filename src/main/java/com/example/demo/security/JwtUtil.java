package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    private SecretKey key;

    /* 🔐 Initialize secret key */
    public void initKey() {
        this.key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
    }

    /* ✅ GENERATE TOKEN USING USER ENTITY */
    public String generateTokenForUser(UserAccount user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)
                ) // 24 hours
                .signWith(key)
                .compact();
    }

    /* 🔍 Extract username */
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    /* ✅ Validate token */
    public boolean validateToken(String token) {
        extractClaims(token);
        return true;
    }

    /* 🔒 Internal claim extraction */
    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
