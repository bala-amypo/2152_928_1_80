package com.example.demo.Service;

import java.util.List;
import com.example.demo.Entity.BranchProfileEntity;

public interface BranchProfileService {

    BranchProfileEntity createBranch(BranchProfileEntity branch);

    BranchProfileEntity updateBranchStatus(Long id, boolean active);

    List<BranchProfileEntity> getAllBranches();

    BranchProfileEntity getBranchById(Long id);

    BranchProfileEntity findByBranchCode(String branchCode);
}