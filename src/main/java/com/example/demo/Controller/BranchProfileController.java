package com.example.demo.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.BranchProfileEntity;
import com.example.demo.Service.BranchProfileService;

@RestController
@RequestMapping("/api/branches")
public class BranchProfileController {

    private final BranchProfileService branchService;

    public BranchProfileController(BranchProfileService branchService) {
        this.branchService = branchService;
    }

    // CREATE BRANCH
    @PostMapping
    public BranchProfileEntity createBranch(@RequestBody BranchProfileEntity branch) {
        return branchService.createBranch(branch);
    }

    // UPDATE BRANCH STATUS
    @PutMapping("/{id}/status")
    public BranchProfileEntity updateStatus(@PathVariable Long id,@RequestParam boolean active) {
        return branchService.updateBranchStatus(id, active);
    }

    // GET ALL BRANCHES
    @GetMapping
    public List<BranchProfile> getAllBranches() {
        return branchService.getAllBranches();
    }

    // GET BRANCH BY ID
    @GetMapping("/{id}")
    public BranchProfileEntity getBranchById(@PathVariable Long id) {
        return branchService.getBranchById(id);
    }

    // GET BRANCH BY CODE
    @GetMapping("/code/{branchCode}")
    public BranchProfileEntity getByBranchCode(@PathVariable String branchCode) {
        return branchService.findByBranchCode(branchCode);
    }
}