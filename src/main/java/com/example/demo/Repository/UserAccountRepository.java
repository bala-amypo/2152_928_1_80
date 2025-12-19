package com.example.demo.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.UserAccountEntity;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Long> {

    boolean existsByEmail(String email);

    Optional<UserAccountEntity> findByEmail(String email);
}