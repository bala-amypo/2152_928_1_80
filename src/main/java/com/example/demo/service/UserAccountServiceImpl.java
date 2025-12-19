package com.example.demo.serviceimpl;

import com.example.demo.entity.UserAccountEntity;
import com.example.demo.exception.*;
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

    public UserAccountEntity register(UserAccountEntity user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new ValidationException("Email already exists");
        }
        return repository.save(user);
    }

    public UserAccountEntity getUser(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public List<UserAccountEntity> getAllUsers() {
        return repository.findAll();
    }

    public UserAccountEntity findByEmail(String email) {
        UserAccountEntity user = repository.findByEmail(email);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        return user;
    }
}
