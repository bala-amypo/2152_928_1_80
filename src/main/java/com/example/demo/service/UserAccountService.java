package com.example.demo.service;

import com.example.demo.entity.UserAccountEntity;
import java.util.List;

public interface UserAccountService {
    UserAccountEntity register(UserAccountEntity user);
    UserAccountEntity getUser(Long id);
    List<UserAccountEntity> getAllUsers();
    UserAccountEntity findByEmail(String email);

    UserAccountEntity createUser(UserAccountEntity user);
    UserAccountEntity getUserById(Long id);
    void updateUserStatus(Long id, boolean active);
}
