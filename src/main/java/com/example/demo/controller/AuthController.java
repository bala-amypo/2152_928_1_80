package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final UserAccountService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserAccountService userService,JwtUtil jwtUtil,PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    @Operation(summary = "Register new user")
    public ApiResponse<UserAccount> register(@RequestBody RegisterRequest req) {

        UserAccount user = new UserAccount();
        user.setFullName(req.getName());
user.setEmail(req.getEmail());
user.setPassword(req.getPassword());
user.setRole(req.getRole());
user.setDepartment(req.getDepartment());


        UserAccount saved = userService.register(user);
        return new ApiResponse<>(true, "User registered", saved);
    }

    @PostMapping("/login")
    @Operation(summary = "Login and generate JWT")
    public ApiResponse<String> login(@RequestBody LoginRequest req) {

        UserAccount user = userService.findByEmail(req.getEmail());
if (!passwordEncoder.matches(req.getPassword(), user.getPassword()))  {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateTokenForUser(user);
        return new ApiResponse<>(true, "Login successful", token);
    }

    @GetMapping("/users")
    @Operation(summary = "Get all users (ADMIN only)")
    public ApiResponse<?> getAllUsers() {
        return new ApiResponse<>(true, "Users fetched", userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    @Operation(summary = "Get user by ID (ADMIN only)")
    public ApiResponse<?> getUser(@PathVariable Long id) {
        return new ApiResponse<>(true, "User fetched", userService.getUser(id));
    }
}
