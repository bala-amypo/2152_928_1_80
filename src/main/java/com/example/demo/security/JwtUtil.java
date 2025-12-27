package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private SecretKey key;

    /* =====================================================
       INITIALIZE SECRET KEY
       ===================================================== */
    public void initKey() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    /* =====================================================
       TOKEN GENERATION
       ===================================================== */

    // ✅ Used by AuthController
    public String generateTokenForUser(UserAccount user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole());
        claims.put("userId", user.getId());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())   // EMAIL = USERNAME
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)
                ) // 24 hours
                .signWith(key)
                .compact();
    }

    // ✅ REQUIRED BY TESTS
    public String generateToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 1000 * 60 * 60)
                ) // 1 hour
                .signWith(key)
                .compact();
    }

    /* =====================================================
       TOKEN VALIDATION
       ===================================================== */

    public boolean validateToken(String token) {
        try {
            extractAllClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ REQUIRED BY TESTS
    public boolean isTokenValid(String token, String username) {
        String extractedUsername = extractUsername(token);
        return extractedUsername.equals(username) && !isTokenExpired(token);
    }

    /* =====================================================
       CLAIM EXTRACTION
       ===================================================== */

    // ✅ REQUIRED BY FILTER + TESTS
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    // ✅ REQUIRED BY TESTS
    public Long extractUserId(String token) {
        Object id = extractAllClaims(token).get("userId");
        return id == null ? null : Long.parseLong(id.toString());
    }

    // ✅ REQUIRED BY TESTS
    public Claims parseToken(String token) {
        return extractAllClaims(token);
    }

    /* =====================================================
       INTERNAL HELPERS
       ===================================================== */

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token)
                .getExpiration()
                .before(new Date());
    }
}
