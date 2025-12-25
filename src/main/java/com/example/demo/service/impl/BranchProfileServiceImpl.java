package com.example.demo.service.impl;

import com.example.demo.entity.BranchProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BranchProfileRepository;

import java.util.List;

public class BranchProfileServiceImpl {

    private final BranchProfileRepository repository;

    public BranchProfileServiceImpl(BranchProfileRepository repository) {
        this.repository = repository;
    }

    public BranchProfile createBranch(BranchProfile branch) {
        branch.prePersist();
        return repository.save(branch);
    }

    public BranchProfile updateBranchStatus(Long id, boolean active) {
        BranchProfile branch = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Branch not found"));
        branch.setActive(active);
        return repository.save(branch);
    }

    public List<BranchProfile> getAllBranches() {
        return repository.findAll();
    }
}
