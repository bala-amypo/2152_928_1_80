package com.example.demo.controller;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/branches")
@Tag(name = "Branch Profiles")
public class BranchProfileController {

    private final BranchProfileService service;

    public BranchProfileController(BranchProfileService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create branch")
    public BranchProfile create(@RequestBody BranchProfile branch) {
        return service.createBranch(branch);
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Update branch status")
    public BranchProfile updateStatus(@PathVariable Long id,
                                      @RequestParam boolean active) {
        return service.updateBranchStatus(id, active);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get branch by ID")
    public BranchProfile getById(@PathVariable Long id) {
        return service.getBranchById(id);
    }

    @GetMapping
    @Operation(summary = "Get all branches")
    public Object getAll() {
        return service.getAllBranches();
    }

    @GetMapping("/lookup/{branchCode}")
    @Operation(summary = "Find branch by branch code")
    public BranchProfile findByCode(@PathVariable String branchCode) {
        return service.findByBranchCode(branchCode);
    }
}
