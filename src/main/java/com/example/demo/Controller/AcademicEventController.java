AcademicEventController.java


package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    private final AcademicEventService eventService;

    public AcademicEventController(AcademicEventService eventService) {
        this.eventService = eventService;
    }

    // CREATE EVENT
    @PostMapping
    public AcademicEvent createEvent(@RequestBody AcademicEvent event) {
        return eventService.createEvent(event);
    }

    // UPDATE EVENT
    @PutMapping("/{id}")
    public AcademicEvent updateEvent(@PathVariable Long id,
                                     @RequestBody AcademicEvent event) {
        return eventService.updateEvent(id, event);
    }

    // GET ALL EVENTS
    @GetMapping
    public List<AcademicEvent> getAllEvents() {
        return eventService.getAllEvents();
    }

    // GET EVENT BY ID
    @GetMapping("/{id}")
    public AcademicEvent getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    // GET EVENTS BY BRANCH
    @GetMapping("/branch/{branchId}")
    public List<AcademicEvent> getEventsByBranch(@PathVariable Long branchId) {
        return eventService.getEventsByBranch(branchId);
    }
}