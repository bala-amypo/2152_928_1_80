BranchProfileController.java

package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;

@RestController
@RequestMapping("/api/branches")
public class BranchProfileController {

    private final BranchProfileService branchService;

    public BranchProfileController(BranchProfileService branchService) {
        this.branchService = branchService;
    }

    // CREATE BRANCH
    @PostMapping
    public BranchProfile createBranch(@RequestBody BranchProfile branch) {
        return branchService.createBranch(branch);
    }

    // UPDATE BRANCH STATUS
    @PutMapping("/{id}/status")
    public BranchProfile updateStatus(@PathVariable Long id,
                                      @RequestParam boolean active) {
        return branchService.updateBranchStatus(id, active);
    }

    // GET ALL BRANCHES
    @GetMapping
    public List<BranchProfile> getAllBranches() {
        return branchService.getAllBranches();
    }

    // GET BRANCH BY ID
    @GetMapping("/{id}")
    public BranchProfile getBranchById(@PathVariable Long id) {
        return branchService.getBranchById(id);
    }

    // GET BRANCH BY CODE
    @GetMapping("/code/{branchCode}")
    public BranchProfile getByBranchCode(@PathVariable String branchCode) {
        return branchService.findByBranchCode(branchCode);
    }
}