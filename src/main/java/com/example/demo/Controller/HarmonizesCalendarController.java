HarmonizedCalendarController.java

package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService calendarService;

    public HarmonizedCalendarController(HarmonizedCalendarService calendarService) {
        this.calendarService = calendarService;
    }

    // GENERATE CALENDAR
    @PostMapping("/generate")
    public HarmonizedCalendar generateCalendar(@RequestParam String title,
                                               @RequestParam String generatedBy) {
        return calendarService.generateHarmonizedCalendar(title, generatedBy);
    }

    // GET ALL CALENDARS
    @GetMapping
    public List<HarmonizedCalendar> getAllCalendars() {
        return calendarService.getAllCalendars();
    }

    // GET CALENDAR BY ID
    @GetMapping("/{id}")
    public HarmonizedCalendar getCalendarById(@PathVariable Long id) {
        return calendarService.getCalendarById(id);
    }
}