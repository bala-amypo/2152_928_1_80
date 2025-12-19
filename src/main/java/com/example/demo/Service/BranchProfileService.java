package com.example.demo.service;

import com.example.demo.entity.BranchProfileEntity;
import java.util.List;

public interface BranchProfileService {

    BranchProfileEntity createBranch(BranchProfileEntity branch);

    BranchProfileEntity updateBranchStatus(Long id, boolean active);

    List<BranchProfileEntity> getAllBranches();

    BranchProfileEntity getBranchById(Long id);

    BranchProfileEntity findByBranchCode(String branchCode);
}
