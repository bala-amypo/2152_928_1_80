package com.example.demo.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.UserAccountEntity;
import com.example.demo.Service.UserAccountService;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    // REGISTER USER
    @PostMapping("/register")
    public UserAccountEntity registerUser(@RequestBody UserAccountEntity user) {
        return userService.register(user);
    }

    // GET ALL USERS
    @GetMapping
    public List<UserAccountEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public UserAccountEntity getUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }

    // GET USER BY EMAIL
    @GetMapping("/email/{email}")
    public UserAccountEntity getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}