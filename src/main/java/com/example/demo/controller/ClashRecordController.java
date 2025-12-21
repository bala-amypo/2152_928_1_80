package com.example.demo.controller;

import com.example.demo.entity.ClashRecordEntity;
import com.example.demo.service.ClashDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashDetectionService clashDetectionService;

    public ClashRecordController(ClashDetectionService clashDetectionService) {
        this.clashDetectionService = clashDetectionService;
    }

    @GetMapping
    public List<ClashRecordEntity> getAll() {
        return clashDetectionService.getAllClashRecords();
    }

    @GetMapping("/{id}")
    public ClashRecordEntity getById(@PathVariable Long id) {
        return clashDetectionService.getClashRecordById(id);
    }

    @GetMapping("/resolved")
    public List<ClashRecordEntity> getResolved(@RequestParam Boolean resolved) {
        return clashDetectionService.getByResolved(resolved);
    }

    @PostMapping
    public ClashRecordEntity create(@RequestBody ClashRecordEntity record) {
        return clashDetectionService.saveClashRecord(record);
    }
}
