package com.example.demo.controller;

import com.example.demo.entity.EventMergeRecordEntity;
import com.example.demo.service.EventMergeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/event-merges")
public class EventMergeController {

    private final EventMergeService service;

    public EventMergeController(EventMergeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EventMergeRecordEntity> merge(
            @RequestParam List<Long> eventIds,
            @RequestParam String reason) {
        return ResponseEntity.ok(service.mergeEvents(eventIds, reason));
    }

    @GetMapping
    public ResponseEntity<List<EventMergeRecordEntity>> getAll() {
        return ResponseEntity.ok(service.getAllMergeRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventMergeRecordEntity> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getMergeRecordById(id));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<EventMergeRecordEntity>> byDate(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return ResponseEntity.ok(
                service.getMergeRecordsByDate(start, end));
    }
}
