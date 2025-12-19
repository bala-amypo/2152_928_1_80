package com.example.demo.controller;

import com.example.demo.entity.ClashRecordEntity;
import com.example.demo.service.ClashDetectionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashDetectionService clashDetectionService;

    public ClashRecordController(ClashDetectionService clashDetectionService) {
        this.clashDetectionService = clashDetectionService;
    }

    /**
     * Log a new clash
     */
    @PostMapping
    public ResponseEntity<ClashRecordEntity> logClash(
            @Valid @RequestBody ClashRecordEntity clash) {
        return ResponseEntity.ok(
                clashDetectionService.logClash(clash)
        );
    }

    /**
     * Resolve a clash
     */
    @PutMapping("/{id}/resolve")
    public ResponseEntity<ClashRecordEntity> resolveClash(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                clashDetectionService.resolveClash(id)
        );
    }

    /**
     * Get clashes for a specific event
     */
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<ClashRecordEntity>> getClashesForEvent(
            @PathVariable Long eventId) {
        return ResponseEntity.ok(
                clashDetectionService.getClashesForEvent(eventId)
        );
    }

    /**
     * Get unresolved clashes
     */
    @GetMapping("/unresolved")
    public ResponseEntity<List<ClashRecordEntity>> getUnresolvedClashes() {
        return ResponseEntity.ok(
                clashDetectionService.getUnresolvedClashes()
        );
    }

    /**
     * Get all clashes
     */
    @GetMapping
    public ResponseEntity<List<ClashRecordEntity>> getAllClashes() {
        return ResponseEntity.ok(
                clashDetectionService.getAllClashes()
        );
    }
}
