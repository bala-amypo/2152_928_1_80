package com.example.demo.serviceimpl;

import com.example.demo.entity.HarmonizedCalendarEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HarmonizedCalendarRepository;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.GenerateCalendarRequest;
import com.example.demo.entity.HarmonizedCalendarEntity;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HarmonizedCalendarServiceImpl implements HarmonizedCalendarService {

    private final HarmonizedCalendarRepository repository;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository repository) {
        this.repository = repository;
    }
    @RestController     
    @RequestMapping("/api/calendars")
    public class HarmonizedCalendarController {

    @PostMapping("/generate")
    public HarmonizedCalenderEntity<HarmonizedCalendarEntity> generateCalendar(
            @RequestBody GenerateCalendarRequest request) {

            HarmonizedCalendarEntity calendar = service.generate(request);
            return ResponseEntity.ok(calendar);
    }
}


    @Override
    public HarmonizedCalendarEntity getCalendarById(Long id) {
        return repository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Calendar not found"));
    }

    @Override
    public List<HarmonizedCalendarEntity> getAllCalendars() {
        return repository.findAll();
    }

    @Override
    public List<HarmonizedCalendarEntity> getCalendarsWithinRange(LocalDate start, LocalDate end) {
    return repository.findAll().stream().filter(c -> !c.getEffectiveFrom().isBefore(start) && !c.getEffectiveTo().isAfter(end)).collect(Collectors.toList());
    }
}

