package com.example.demo.serviceimpl;

import com.example.demo.entity.BranchProfileEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.BranchProfileRepository;
import com.example.demo.service.BranchProfileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BranchProfileServiceImpl implements BranchProfileService {

    private final BranchProfileRepository repository;

    public BranchProfileServiceImpl(BranchProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public BranchProfileEntity createBranch(BranchProfileEntity branch) {
        if (repository.findByBranchCode(branch.getBranchCode()) != null) {
            throw new ValidationException("Branch code already exists");
        }

        if (branch.getEvents() != null) {
            branch.getEvents().forEach(e -> e.setBranch(branch)); // set branch reference
        }

        return repository.save(branch);
    }

    @Override
    public BranchProfileEntity updateBranchStatus(Long id, boolean active) {
        BranchProfileEntity branch = getBranchById(id);
        branch.setActive(active);
        return repository.save(branch);
    }

    @Override
    public List<BranchProfileEntity> getAllBranches() {
        return repository.findAll();
    }

    @Override
    public BranchProfileEntity getBranchById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found with id: " + id));
    }

    @Override
    public BranchProfileEntity findByBranchCode(String branchCode) {
        BranchProfileEntity branch = repository.findByBranchCode(branchCode);
        if (branch == null) {
            throw new ResourceNotFoundException("Branch not found with code: " + branchCode);
        }
        return branch;
    }
}
