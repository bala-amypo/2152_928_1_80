package com.example.demo.controller;

import com.example.demo.entity.AcademicEventEntity;
import com.example.demo.service.AcademicEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    private final AcademicEventService service;

    public AcademicEventController(AcademicEventService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public AcademicEventEntity createEvent(@RequestBody AcademicEventEntity event) {
        return service.createEvent(event);
    }

    // GET BY TITLE (ID)
    @GetMapping("/{title}")
    public AcademicEventEntity getEventById(@PathVariable String title) {
        return service.getEventById(title);
    }

    // UPDATE
    @PutMapping("/{title}")
    public AcademicEventEntity updateEvent(
            @PathVariable String title,
            @RequestBody AcademicEventEntity event) {
        return service.updateEvent(title, event);
    }

    // GET ALL
    @GetMapping
    public List<AcademicEventEntity> getAllEvents() {
        return service.getAllEvents();
    }

    // GET BY BRANCH
    @GetMapping("/branch/{branchId}")
    public List<AcademicEventEntity> getEventsByBranch(@PathVariable Long branchId) {
        return service.getEventsByBranch(branchId);
    }
}

    