package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
@Tag(name = "Academic Events")
public class AcademicEventController {

    private final AcademicEventService service;

    public AcademicEventController(AcademicEventService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create academic event")
    public AcademicEvent create(@RequestBody AcademicEvent event) {
        return service.createEvent(event);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update academic event")
    public AcademicEvent update(@PathVariable Long id,
                                @RequestBody AcademicEvent event) {
        return service.updateEvent(id, event);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get event by ID")
    public AcademicEvent getById(@PathVariable Long id) {
        return service.getEventById(id);
    }

    @GetMapping("/branch/{branchId}")
    @Operation(summary = "Get events by branch")
    public Object getByBranch(@PathVariable Long branchId) {
        return service.getEventsByBranch(branchId);
    }

    @GetMapping
    @Operation(summary = "Get all events")
    public Object getAll() {
        return service.getAllEvents();
    }
}
