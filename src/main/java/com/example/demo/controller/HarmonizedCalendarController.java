package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendarEntity;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.GenerateCalendarRequest;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService service;

    public HarmonizedCalendarController(
            HarmonizedCalendarService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<HarmonizedCalendarEntity> createCalendar(
            @RequestBody GenerateCalendarRequest request) {

        HarmonizedCalendarEntity calendar =
                service.generateHarmonizedCalendar(request.title(), request.generatedBy());

        return ResponseEntity.ok(calendar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HarmonizedCalendarEntity> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getCalendarById(id));
    }

    @GetMapping
    public ResponseEntity<List<HarmonizedCalendarEntity>> getAll() {
        return ResponseEntity.ok(service.getAllCalendars());
    }

    @GetMapping("/range")
    public ResponseEntity<List<HarmonizedCalendarEntity>> byRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return ResponseEntity.ok(
                service.getCalendarsWithinRange(start, end));
    }
}
