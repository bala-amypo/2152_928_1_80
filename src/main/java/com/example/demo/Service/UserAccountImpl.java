package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.UserAccountEntity;
import com.example.demo.Repository.UserAccountRepository;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserAccountEntity register(UserAccountEntity user) {
        
        user.setCreatedAt(LocalDateTime.now());
        return repo.save(user);
    }

    @Override
    public UserAccountEntity getUser(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<UserAccountEntity> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public UserAccountEntity findByEmail(String email) {
        return repo.findByEmail(email);
    }
}