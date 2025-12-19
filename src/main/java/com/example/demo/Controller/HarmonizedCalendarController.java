package com.example.demo.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.HarmonizedCalendarEntity;
import com.example.demo.Service.HarmonizedCalendarService;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService calendarService;

    public HarmonizedCalendarController(HarmonizedCalendarService calendarService) {
        this.calendarService = calendarService;
    }

    // GENERATE CALENDAR
    @PostMapping("/generate")
    public HarmonizedCalendarEntity generateCalendar(@RequestParam String title,@RequestParam String generatedBy) {
        return calendarService.generateHarmonizedCalendar(title, generatedBy);
    }

    // GET ALL CALENDARS
    @GetMapping
    public List<HarmonizedCalendarEntity> getAllCalendars() {
        return calendarService.getAllCalendars();
    }

    // GET CALENDAR BY ID
    @GetMapping("/{id}")
    public HarmonizedCalendarEntity getCalendarById(@PathVariable Long id) {
        return calendarService.getCalendarById(id);
    }
}