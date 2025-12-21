package com.example.demo.repository;

import com.example.demo.entity.BranchProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchProfileRepository extends JpaRepository<BranchProfileEntity, Long> {
    BranchProfileEntity findByBranchCode(String branchCode);
}
