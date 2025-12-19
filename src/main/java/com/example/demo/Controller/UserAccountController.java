package com.example.demo.controller;

import com.example.demo.entity.UserAccountEntity;
import com.example.demo.service.UserAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public UserAccountEntity register(@RequestBody UserAccountEntity user) {
        return service.register(user);
    }

    @GetMapping("/users")
    public List<UserAccountEntity> users() {
        return service.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserAccountEntity user(@PathVariable Long id) {
        return service.getUser(id);
    }
}
