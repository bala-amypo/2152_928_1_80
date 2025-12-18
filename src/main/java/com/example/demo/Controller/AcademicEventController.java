package com.example.demo.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.AcademicEventEntity;
import com.example.demo.Service.AcademicEventService;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    private final AcademicEventService eventService;

    public AcademicEventController(AcademicEventService eventService) {
        this.eventService = eventService;
    }

    // CREATE EVENT
    @PostMapping
    public AcademicEvent createEvent(@RequestBody AcademicEventEntity event) {
        return eventService.createEvent(event);
    }

    // UPDATE EVENT
    @PutMapping("/{id}")
    public AcademicEventEntity updateEvent(@PathVariable Long id,
                                     @RequestBody AcademicEventEntity event) {
        return eventService.updateEvent(id, event);
    }

    // GET ALL EVENTS
    @GetMapping
    public List<AcademicEventEntity> getAllEvents() {
        return eventService.getAllEvents();
    }

    // GET EVENT BY ID
    @GetMapping("/{id}")
    public AcademicEventEntity getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    // GET EVENTS BY BRANCH
    @GetMapping("/branch/{branchId}")
    public List<AcademicEventEntity> getEventsByBranch(@PathVariable Long branchId) {
        return eventService.getEventsByBranch(branchId);
    }
}