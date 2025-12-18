HarmonizedCalendarServiceImpl.java

package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.repository.HarmonizedCalendarRepository;

@Service
public class HarmonizedCalendarServiceImpl implements HarmonizedCalendarService {

    private final HarmonizedCalendarRepository repo;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository repo) {
        this.repo = repo;
    }

    @Override
    public HarmonizedCalendar generateHarmonizedCalendar(String title, String generatedBy) {
        HarmonizedCalendar cal = new HarmonizedCalendar();
        cal.setTitle(title);
        cal.setGeneratedBy(generatedBy);
        cal.setGeneratedAt(LocalDateTime.now());
        return repo.save(cal);
    }

    @Override
    public HarmonizedCalendar getCalendarById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<HarmonizedCalendar> getAllCalendars() {
        return repo.findAll();
    }

    @Override
    public List<HarmonizedCalendar> getCalendarsWithinRange(LocalDate start, LocalDate end) {
        return repo.findByEffectiveFromBetween(start, end);
    }
}