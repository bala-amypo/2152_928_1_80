package com.example.demo.repository;

import com.example.demo.entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Long> {

    boolean existsByEmail(String email);
    UserAccountEntity findByEmail(String email);
}

