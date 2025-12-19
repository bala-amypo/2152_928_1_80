package com.example.demo.controller;

import com.example.demo.entity.BranchProfileEntity;
import com.example.demo.service.BranchProfileService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchProfileController {

    private final BranchProfileService service;

    public BranchProfileController(BranchProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BranchProfileEntity> createBranch(
            @Valid @RequestBody BranchProfileEntity branch) {
        return ResponseEntity.ok(service.createBranch(branch));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchProfileEntity> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getBranchById(id));
    }

    @GetMapping
    public ResponseEntity<List<BranchProfileEntity>> getAll() {
        return ResponseEntity.ok(service.getAllBranches());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<BranchProfileEntity> updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return ResponseEntity.ok(service.updateBranchStatus(id, active));
    }
}
