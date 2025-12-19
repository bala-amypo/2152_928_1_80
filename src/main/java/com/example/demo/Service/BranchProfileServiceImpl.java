package com.example.demo.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.BranchProfileEntity;
import com.example.demo.Repository.BranchProfileRepository;

@Service
public class BranchProfileServiceImpl implements BranchProfileService {

    private final BranchProfileRepository repo;

    public BranchProfileServiceImpl(BranchProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public BranchProfileEntity createBranch(BranchProfileEntity branch) {
        return repo.save(branch);
    }

    @Override
    public BranchProfileEntity updateBranchStatus(Long id, boolean active) {
        BranchProfileEntity branch = getBranchById(id);
        branch.setActive(active);
        return repo.save(branch);
    }

    @Override
    public List<BranchProfileEntity> getAllBranches() {
        return repo.findAll();
    }

    @Override
    public BranchProfileEntity getBranchById(Long id) {
        //return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Branch not found"));
    }

    @Override
    public BranchProfileEntity findByBranchCode(String branchCode) {
        //return repo.findByBranchCode(branchCode).orElseThrow(() -> new ResourceNotFoundException("Branch code not found"));
    }
}