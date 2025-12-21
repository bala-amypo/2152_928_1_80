package com.example.demo.repository;

import com.example.demo.entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Long> {
    boolean existsByEmail(String email);
}
