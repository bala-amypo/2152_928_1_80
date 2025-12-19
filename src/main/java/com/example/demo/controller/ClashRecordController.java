package com.example.demo.controller;

import com.example.demo.entity.ClashRecordEntity;
import com.example.demo.service.ClashDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashDetectionService service;

    public ClashRecordController(ClashDetectionService service) {
        this.service = service;
    }

    @PostMapping
    public ClashRecordEntity logClash(@RequestBody ClashRecordEntity clash) {
        return service.logClash(clash);
    }

    @GetMapping("/event/{eventId}")
    public List<ClashRecordEntity> getClashesForEvent(@PathVariable Long eventId) {
        return service.getClashesForEvent(eventId);
    }

    @GetMapping("/unresolved")
    public List<ClashRecordEntity> getUnresolvedClashes() {
        return service.getUnresolvedClashes();
    }

    @PutMapping("/{id}/resolve")
    public void resolveClash(@PathVariable Long id) {
        service.resolveClash(id);
    }

    @GetMapping
    public List<ClashRecordEntity> getAllClashes() {
        return service.getAllClashes();
    }
}
