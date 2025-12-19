package com.example.demo.controller;

import com.example.demo.entity.UserAccountEntity;
import com.example.demo.service.UserAccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserAccountEntity> create(
            @Valid @RequestBody UserAccountEntity user) {
        return ResponseEntity.ok(service.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccountEntity> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserAccountEntity>> getAll() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<UserAccountEntity> updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return ResponseEntity.ok(service.updateUserStatus(id, active));
    }
}
