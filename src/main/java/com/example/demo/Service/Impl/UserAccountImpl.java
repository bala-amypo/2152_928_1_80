UserAccountServiceImpl.java

package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.UserAccountEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.Repository.UserAccountRepository;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserAccountEntity register(UserAccountEntity user) {
        if (repo.existsByEmail(user.getEmail())) {
            throw new ValidationException("Email already exists");
        }
        user.setCreatedAt(LocalDateTime.now());
        return repo.save(user);
    }

    @Override
    public UserAccountEntity getUser(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<UserAccountEntity> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public UserAccountEntity findByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}