package com.example.demo.controller;

import com.example.demo.entity.AcademicEventEntity;
import com.example.demo.service.AcademicEventService;
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
    public ResponseEntity<AcademicEventEntity> createEvent(
            @RequestBody AcademicEventEntity event) {

        return ResponseEntity.ok(service.save(event));
    }

    @GetMapping
    public ResponseEntity<List<AcademicEventEntity>> getEvents() {
        return ResponseEntity.ok(service.findAll());
    }
}
