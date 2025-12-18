package com.example.demo.Service;

import java.util.List;
import com.example.demo.Entity.UserAccountEntity;

public interface UserAccountService {

    UserAccountEntity register(UserAccountEntity user);

    UserAccountEntity getUser(Long id);

    List<UserAccountEntity> getAllUsers();

    UserAccountEntity findByEmail(String email);
}