HarmonizedCalendarServiceImpl.java

package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.HarmonizedCalendarEntity;
import com.example.demo.Repository.HarmonizedCalendarRepository;

@Service
public class HarmonizedCalendarServiceImpl implements HarmonizedCalendarService {

    private final HarmonizedCalendarRepository repo;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository repo) {
        this.repo = repo;
    }

    @Override
    public HarmonizedCalendarEntity generateHarmonizedCalendar(String title, String generatedBy) {
        HarmonizedCalendarEntity cal = new HarmonizedCalendarEntity();
        cal.setTitle(title);
        cal.setGeneratedBy(generatedBy);
        cal.setGeneratedAt(LocalDateTime.now());
        return repo.save(cal);
    }

    @Override
    public HarmonizedCalendarEntity getCalendarById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<HarmonizedCalendarEntity> getAllCalendars() {
        return repo.findAll();
    }

    @Override
    public List<HarmonizedCalendarEntity> getCalendarsWithinRange(LocalDate start, LocalDate end) {
        return repo.findByEffectiveFromBetween(start, end);
    }
}