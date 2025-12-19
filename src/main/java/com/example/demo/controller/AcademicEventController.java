package com.example.demo.controller;

import com.example.demo.entity.AcademicEventEntity;
import com.example.demo.service.AcademicEventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    private final AcademicEventService service;

    public AcademicEventController(AcademicEventService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AcademicEventEntity> create(
            @Valid @RequestBody AcademicEventEntity event) {
        return ResponseEntity.ok(service.createEvent(event));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicEventEntity> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getEventById(id));
    }

    @GetMapping
    public ResponseEntity<List<AcademicEventEntity>> getAll() {
        return ResponseEntity.ok(service.getAllEvents());
    }

    @GetMapping("/branch/{branchId}")
    public ResponseEntity<List<AcademicEventEntity>> byBranch(
            @PathVariable Long branchId) {
        return ResponseEntity.ok(service.getEventsByBranch(branchId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicEventEntity> update(
            @PathVariable Long id,
            @Valid @RequestBody AcademicEventEntity event) {
        return ResponseEntity.ok(service.updateEvent(id, event));
    }
}
