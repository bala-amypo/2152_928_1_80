package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

private final JwtUtil jwtUtil;

public JwtAuthenticationFilter(JwtUtil jwtUtil) {
this.jwtUtil = jwtUtil;
}

@Override
protected void doFilterInternal(
HttpServletRequest request,
HttpServletResponse response,
FilterChain filterChain
) throws ServletException, IOException {

String path = request.getRequestURI();

/* ✅ Skip JWT for public endpoints */
if (
path.startsWith("/auth/")
|| path.startsWith("/v3/api-docs")
|| path.startsWith("/swagger-ui")
) {
filterChain.doFilter(request, response);
return;
}

String authHeader = request.getHeader("Authorization");

/* ✅ If no token, continue (Spring Security will handle access) */
if (authHeader == null || !authHeader.startsWith("Bearer ")) {
filterChain.doFilter(request, response);
return;
}

String token = authHeader.substring(7);

if (jwtUtil.validateToken(token)) {
String username = jwtUtil.extractUsername(token);

UsernamePasswordAuthenticationToken authentication =
new UsernamePasswordAuthenticationToken(username, null, null);

authentication.setDetails(
new WebAuthenticationDetailsSource().buildDetails(request)
);

SecurityContextHolder.getContext().setAuthentication(authentication);
}

filterChain.doFilter(request, response);
}
}
