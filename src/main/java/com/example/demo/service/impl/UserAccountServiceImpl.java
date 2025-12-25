package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserAccountServiceImpl {

    private UserAccountRepository repo;
    private PasswordEncoder encoder;

    public UserAccountServiceImpl(UserAccountRepository r, PasswordEncoder e) {
        this.repo = r;
        this.encoder = e;
    }

    public UserAccount register(UserAccount u) {
        if (repo.existsByEmail(u.getEmail()))
            throw new ValidationException("Email already in use");

        if (u.getPassword().length() < 8)
            throw new ValidationException("Password must be at least 8 characters");

        u.setRole(u.getRole() == null ? "REVIEWER" : u.getRole());
        u.prePersist();
        u = new UserAccount(null, null, u.getEmail(),
                encoder.encode(u.getPassword()), u.getRole(), null, u.getCreatedAt());
        return repo.save(u);
    }

    public UserAccount getUser(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
