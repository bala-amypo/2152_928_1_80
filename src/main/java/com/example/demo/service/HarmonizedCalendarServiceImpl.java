package com.example.demo.serviceimpl;

import com.example.demo.entity.HarmonizedCalendarEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HarmonizedCalendarRepository;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HarmonizedCalendarServiceImpl implements HarmonizedCalendarService {

    private final HarmonizedCalendarRepository repository;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository repository) {
        this.repository = repository;
    }

    @Override
    public HarmonizedCalendarEntity generateHarmonizedCalendar(String title, String generatedBy) {

        HarmonizedCalendarEntity calendar = new HarmonizedCalendarEntity();
        calendar.setTitle(title);
        calendar.setGeneratedBy(generatedBy);

        return repository.save(calendar);
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


