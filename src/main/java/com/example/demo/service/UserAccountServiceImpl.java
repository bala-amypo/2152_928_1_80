package com.example.demo.service.impl;

import com.example.demo.entity.UserAccountEntity;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccountEntity createUser(UserAccountEntity user) {
        // Check for duplicate email
        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return repository.save(user);
    }

    @Override
    public UserAccountEntity getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserAccountEntity> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void updateUserStatus(Long id, boolean active) {
        UserAccountEntity user = getUserById(id);
        user.setActive(active);
        repository.save(user);
    }
}
