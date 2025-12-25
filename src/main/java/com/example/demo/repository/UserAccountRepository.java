package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;
public interface UserAccountRepository {
    boolean existsByEmail(String email);
    Optional<UserAccount> findById(Long id);
    Optional<UserAccount> findByEmail(String email);
    UserAccount save(UserAccount u);
}
