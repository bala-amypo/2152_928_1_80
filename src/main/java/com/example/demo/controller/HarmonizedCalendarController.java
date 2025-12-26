package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/harmonized-calendars")
@Tag(name = "Harmonized Calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService service;

    public HarmonizedCalendarController(HarmonizedCalendarService service) {
        this.service = service;
    }

    @PostMapping("/generate")
    @Operation(summary = "Generate harmonized calendar")
    public HarmonizedCalendar generate(@RequestParam String title,
                                       @RequestParam String generatedBy) {
        return service.generateHarmonizedCalendar(title, generatedBy);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get calendar by ID")
    public HarmonizedCalendar getById(@PathVariable Long id) {
        return service.getCalendarById(id);
    }

    @GetMapping
    @Operation(summary = "Get all calendars")
    public Object getAll() {
        return service.getAllCalendars();
    }

    @GetMapping("/range")
    @Operation(summary = "Get calendars by date range")
    public Object getByRange(@RequestParam LocalDate start,
                             @RequestParam LocalDate end) {
        return service.getCalendarsWithinRange(start, end);
    }
}
