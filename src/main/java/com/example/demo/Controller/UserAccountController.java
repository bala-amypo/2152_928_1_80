UserAccountController.java

package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    // REGISTER USER
    @PostMapping("/register")
    public UserAccount registerUser(@RequestBody UserAccount user) {
        return userService.register(user);
    }

    // GET ALL USERS
    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }

    // GET USER BY EMAIL
    @GetMapping("/email/{email}")
    public UserAccount getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}