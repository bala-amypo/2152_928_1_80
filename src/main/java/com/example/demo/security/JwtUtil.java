package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    private SecretKey key;

    /* Initialize secret key */
    public void initKey() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    /* ================= TOKEN GENERATION ================= */
    public String generateTokenForUser(UserAccount user) {
        return Jwts.builder()
                .setSubject(user.getEmail())          // ✅ EMAIL USED
                .claim("role", user.getRole())        // ✅ ROLE ADDED
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)
                ) // 24 hours
                .signWith(key)
                .compact();
    }

    /* ================= TOKEN VALIDATION ================= */
    public boolean validateToken(String token) {
        extractAllClaims(token);
        return true;
    }

    /* ================= CLAIM EXTRACTION ================= */
    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
