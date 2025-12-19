package com.example.demo.service;

import com.example.demo.entity.UserAccountEntity;
import java.util.List;

public interface UserAccountService {

    UserAccountEntity createUser(UserAccountEntity user);

    UserAccountEntity getUserById(Long id);

    List<UserAccountEntity> getAllUsers();

    void updateUserStatus(Long id, boolean active);

    UserAccountEntity findByEmail(String email);
}
