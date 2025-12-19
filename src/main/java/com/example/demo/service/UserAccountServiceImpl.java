package com.example.demo.service;

import com.example.demo.entity.UserAccountEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccountEntity createUser(UserAccountEntity user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new ValidationException("Email already exists");
        }
        return repository.save(user);
    }

    @Override
    public UserAccountEntity getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<UserAccountEntity> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void updateUserStatus(Long id, boolean active) {
        UserAccountEntity user = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setActive(active);
        repository.save(user);
    }

    @Override
    public UserAccountEntity findByEmail(String email) {
        UserAccountEntity user = repository.findByEmail(email);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        return user;
    }
}
