package com.example.demo.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.BranchProfileEntity;

public interface BranchProfileRepository extends JpaRepository<BranchProfileEntity, Long> {

    Optional<BranchProfileEntity> findByBranchCode(String branchCode);
}